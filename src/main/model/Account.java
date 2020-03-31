package model;


import exception.InvalidInformationException;


// Represents an account having name, sex and data with personal information
public class Account  {
    public String name;    // the account owner name
    public String sex;     // the account owner physical sex, m for male, f for female
//    public Data accountData; //the data to store additional information of the account owner

//      EFFECTS: name on account is set to accountName;
//              sex of the account owner is set to accountSex
    public Account(String accountName, String accountSex) {
        name = accountName;
        sex = accountSex;
//        accountData = new Data();
    }


    // EFFECT: return account owner name
    public String getName() throws NullPointerException {
        if (name != null && !"".equals(name)) {
            return name;
        } else {
            throw new NullPointerException("Please insert your name!");
        }
    }


    // EFFECT: return account owner sex
    public String getSex() throws InvalidInformationException {
        if (sex.equals("f") || sex.equals("m")) {
            return sex;
        } else {
            throw new InvalidInformationException("Invalid Sex !");
        }

    }

    // EFFECT: modify account name
    public void modifyName(String newName) {
        name = newName;
    }

    // EFFECT: modify account sex
    public void modifySex(String newSex) {
        sex = newSex;
    }


//    // EFFECTS: returns the data for the account
//    public Data getData() {
//        return accountData;
//    }


}













