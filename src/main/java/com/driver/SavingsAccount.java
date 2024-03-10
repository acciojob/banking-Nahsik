package com.driver;

public class SavingsAccount extends BankAccount {
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > this.maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if (amount > getBalance()) {
            throw new Exception("Insufficient Balance");
        }
        setBalance(getBalance() - amount);
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal
        // limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

    }

    public double getSimpleInterest(int years) {
        double interest = (years * getBalance() * rate) / 100;
        return interest;
    }

    public double getCompoundInterest(int times, int years) {
        double interest = getBalance() * Math.pow(1 + (rate / 100), times * years);
        return interest;
    }

    public double getRate() {
        return this.rate;
    }

    public double getMaxWithdrawalLimit() {
        return this.maxWithdrawalLimit;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

}
