package com.driver;

public class StudentAccount extends BankAccount {

    String institutionName;

    public StudentAccount(String name, double balance, String institutionName) {
        super(institutionName, balance, 0);
        this.institutionName = institutionName;
    }

    public String getInstitutionName() {
        return this.institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

}
