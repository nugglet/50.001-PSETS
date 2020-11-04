package piano;

import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.NoteEvent;
import music.Pitch;

public class PianoMachine {
	
	private Midi midi;
	private Instrument instrument;
	private int octave = 0;
	private ArrayList<Pitch> playing = new ArrayList<>();
	private boolean isRecording = false;
	private ArrayList<NoteEvent> recording = new ArrayList<>();
	private boolean isPlaying = false;

	/**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
            instrument = Instrument.PIANO;

        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
        }
    }
    /**
     * plays note given if not already playing
     *
     * if already playing a note, end note and play note given
     **/
    public void beginNote(Pitch rawPitch) {
        Pitch pitch = rawPitch;

        if (octave != 0) {
            pitch = pitch.transpose(octave * 12);
        }

        // check if note is already currently playing
        if (!playing.contains(pitch)){
            midi.beginNote(pitch.toMidiFrequency(), this.instrument);
            playing.add(pitch);

            // add to recording if Piano is recording
            if(isRecording){
                NoteEvent event = new NoteEvent(pitch, System.currentTimeMillis(),
                        this.instrument, NoteEvent.Kind.start);
                this.recording.add(event);
            }
        }
    }
    
    /** stops playing note if it is already playing **/
    public void endNote(Pitch rawPitch) {
        Pitch pitch = rawPitch;

        if (octave != 0) {
            pitch = pitch.transpose(octave * 12);
        }
        // check if note is still playing
        if (playing.contains(pitch)){
            midi.endNote(pitch.toMidiFrequency(), this.instrument);
            playing.remove(pitch);

            // add to recording if Piano is recording
            if(isRecording){
                NoteEvent event = new NoteEvent(pitch, System.currentTimeMillis(),
                        this.instrument, NoteEvent.Kind.stop);
                recording.add(event);
            }
        }
    }
    
    /**
     * Changes to next instru in list
     *
     * If at last instru, go back to top of list
     **/
    public void changeInstrument() {
        instrument = instrument.next();

    }
    
    // Shifts pitch one octave up, up two 2 octaves
    public void shiftUp() {
        if (octave < 2){
            octave++;
        }
    }

    /**
     * Shifts pitch one oct down, up to 2 octs
     */
    public void shiftDown() {
    	if (octave > -2){
    	    octave--;
        }
    }

    /**
     * turns on/off recording
     */
    public boolean toggleRecording() {

        if (isRecording == false){
            recording.clear();
        }

        isRecording = !isRecording;

    	return isRecording;
    }
    
    /** plays recording if it exists **/
    public void playback() {

        long prevTime = 0;
        if (!isPlaying){

            isPlaying = true;

            if (!recording.isEmpty()) {

                for (NoteEvent e: recording){
                    if (prevTime > 0){
                        long duration = Math.round((e.getTime() - prevTime) / 10.0);
                        Midi.rest((int) duration);
                    }

                    prevTime = e.getTime();

                    if (e.getKind() == NoteEvent.Kind.start) {

                        midi.beginNote(e.getPitch().toMidiFrequency(), e.getInstr());

                    } else {

                        midi.endNote(e.getPitch().toMidiFrequency(), e.getInstr());

                    }
                }
            }

            isPlaying = false;
        }
    }
}
