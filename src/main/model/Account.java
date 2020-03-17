package model;


import exception.InvalidInformationException;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Account  {
    private static int nextAccountId = 1;  // tracks id of next account created
//    public int id;         // the account id
    public String name;    // the account owner name
    public String sex;     // the account owner physical sex, m for male, f for female
    public Data accountData; //the data to store additional information of the account owner
    public ArrayList<Food> foodArrayList; //the food the owner eat
    public ArrayList<FoodIntake> foodIntakeArrayList; //the food the owner eat with quantity
    public int totalQuantity;

    /*
     * REQUIRES: accountName has a non-zero length
     * EFFECTS: name on account is set to accountName; account id is a
     *          positive integer not assigned to any other account;
     *          sex of the account owner is set to accountSex
     */
    public Account(String accountName, String accountSex) throws InvalidInformationException {
//        id = nextAccountId++;
        name = accountName;
        sex = accountSex;
        totalQuantity = 0;
        accountData = new Data();
        foodArrayList = new ArrayList<>();
        foodIntakeArrayList = new ArrayList<>();
    }

//    /*
//     * REQUIRES: name has a non-zero length, balance >= 0
//     * EFFECTS: constructs an account with id, name and sex
//     * nextAccountId is the id of the next account to be constructed
//     * NOTE: this constructor is to be used only when constructing
//     * an account from data stored in file
//     */
//    public Account(int nextId, int id, String name, String sex) {
//        nextAccountId = nextId;
//        this.id = id;
//        this.name = name;
//        this.sex = sex;
//        foodList = new ArrayList<>();
//    }

//    // EFFECT: return account id
//    public int getId() {
//        return id;
//    }

    // EFFECT: return account owner name
    public String getName() {
        return name;
    }


    // EFFECT: return account owner sex
    public String getSex() throws InvalidInformationException {
        if (sex.equals("f") || sex.equals("m")) {
            return sex;
        } else {
            throw new InvalidInformationException("Invalid Sex !");
        }

    }


//    public void addFood(Food f) {
//        foodList.add(f);
//    }
//
//    public void removeFood(Food f) {
//        foodList.remove(f);
//    }






    // MODIFIES: this
    // EFFECTS: adds food item and quantity to the foodIntakeList, if item has previously been added
    // to this list, quantity of food is increased on previous entry, otherwise adding a new entry
    public void addFood(Food item, int quantity) {
        totalQuantity += quantity;
        if (foodArrayList.contains(item)) {
            int ind = foodArrayList.indexOf(item);
            foodIntakeArrayList.get(ind).addQuantity(quantity);
        } else {
            foodArrayList.add(item);
            FoodIntake obj = new FoodIntake(item, quantity);
            foodIntakeArrayList.add(obj);
        }
    }

    // EFFECTS: returns total number of food ate
    public int getTotalNumberOfFood() {
        return foodArrayList.size();
    }

    // EFFECTS: returns total quantity of the food item
    // returns 0 if the item has not been added to list
    public int getTotalQuantityOfFood(Food item) {
        if (foodArrayList.contains(item)) {
            int ind = foodArrayList.indexOf(item);
            return foodIntakeArrayList.get(ind).getQuantity();
        } else {
            return 0;
        }
    }

    // EFFECTS: returns the data for the account
    public Data getData() {
        return accountData;
    }


}













