package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        int maxPossibleSum = 9 * digits;
        if (sum > maxPossibleSum) {
            throw new Exception("Account Number can not be generated");
        }
        StringBuilder accountNumber = new StringBuilder();
        for(int i=0;i<digits;i++){
             int num = Math.min(9,sum);
             sum-=num;
             accountNumber.append(num);
         }
        return accountNumber.toString();
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > this.minBalance) {
            throw new Exception("Insufficient Balance");
        }
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getMinBalance() {
        return this.minBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }   

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

}