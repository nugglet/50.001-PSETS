package com.isp.midterm2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Account implements Comparable<Account>{

    private String id;
    private double balance;
    private Date dateCreated;

    public Account(String id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getBalance() {
        return balance;
    }

    public String getId(){
        return id;
    }

    @Override
    public String toString() {
        String result = String.format("Account:%s", this.id);
        return result;
    }

    @Override
    public int compareTo(Account account) {
        if (this.balance < account.getBalance()){
            return -1;
        } else if (this.balance == account.getBalance()){
            return 0;
        }
        else {
            return 1;
        }
    }
}

class AccountComparator implements Comparator<Account> {

    @Override
    public int compare(Account account, Account t1) {
        int com = account.getId().compareTo(t1.getId());
        if (com < 0){
            return -1;
        } else if (com > 0){
            return 1;
        } else {
            return com;
        }
    }
}


class TestAcc {
    public static void main(String[] args) {
        Account a = new Account("simon", 20);
        System.out.println(a.getId());
        System.out.println(a.getBalance());
        System.out.println(a);
        ArrayList<Account> l = new ArrayList<>();
        l.add(new Account("man", 30));
        l.add(new Account("eric", 100));
        l.add(new Account("norman", 10));
        Collections.sort(l);
        System.out.println(l);
        Collections.sort(l, new AccountComparator());
        System.out.println(l);
    }
}
