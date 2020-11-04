package com.isp.pset1a;

import java.util.Date;

public class Account {

    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;

    public Account(){ //class constructor
        this.id = 0 ;
        this.balance = 0;
        annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance){
        this.id = id ;
        this.balance = balance;
        annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    public int getId(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public Date getDateCreated(){
        return this.dateCreated;
    }

    public void setId(int newId){
        this.id = newId;
    }

    public void setBalance(double newBalance){
        this.balance = newBalance;
    }

    public static void setAnnualInterestRate(double newInterest){
        annualInterestRate = newInterest;
    }

    public static double getMonthlyInterestRate(){
        double interest = annualInterestRate/12;
        return interest;

    }

    public double getMonthlyInterest(){
        double rate = getMonthlyInterestRate();
        double amt = (rate/100) * this.balance;
        return amt;
    }

    public void withdraw(double x){
        this.balance -= x;
    }

    public void deposit(double x){
        this.balance += x;
    }


    public static void main(String[] args){
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance is " + account.getBalance());
        System.out.println("Monthly interest is " +
                account.getMonthlyInterest());

        Account second = new Account();
        second.deposit(1000);
        second.withdraw(20);
        System.out.println(second.getBalance());
        second.setAnnualInterestRate(4.5);
        System.out.println(second.getAnnualInterestRate());
        System.out.println(second.getMonthlyInterestRate());
        System.out.println(second.getMonthlyInterest());

    }
}

