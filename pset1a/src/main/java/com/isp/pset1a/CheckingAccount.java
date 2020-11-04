package com.isp.pset1a;

public class CheckingAccount extends Account {

    private int overdraftLimit;

    public CheckingAccount(){ //class constructor
        super(); //invoke superclass' constructor
        this.overdraftLimit = 5000;
}

    public CheckingAccount(int id, double balance){
        super(id, balance);
        this.overdraftLimit = 5000;
    }

    @Override
    public void withdraw(double amt){
        if (super.getBalance() < -this.overdraftLimit || super.getBalance() - amt < -this.overdraftLimit){
            System.out.println("over limit");
        }else{
            super.withdraw(amt);
        }
    }


    public static void main(String[] args){
        CheckingAccount myCheckAcc = new CheckingAccount(1024, 8000.0);
        myCheckAcc.deposit(2000);
        myCheckAcc.withdraw(15000);

        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.deposit(7000);
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());

    }
}

