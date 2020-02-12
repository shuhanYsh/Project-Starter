package model;

import java.util.ArrayList;

public class Account {
    public int id;         // the account id
    public int age;        // the account owner age
    public double weight;  // the account owner weight in kg
    public double height;  // the account owner height in cm
    public String name;    // the account owner name
    public String sex;     // the account owner physical sex, male or female
    public String require; // the account owner needs, add or lose weight
    public ArrayList<Food> foodList;
    public int countCalories;

    // EFFECT: set the account on the person's name and assigned id
    public Account(int id, String name) {
        this.id = id;
        this.name = name;
        this.age = 0;
        this.sex = "";
        this.weight = 0.0;
        this.height = 0.0;
        this.require = "";
        foodList = new ArrayList<>();

    }

    // REQUIRES: given age as positive int
    // EFFECT: set the person's age
    public void setAge(int age) {
        this.age = age;
    }

    // REQUIRES: given sex in male or female
    // EFFECT: set the person's sex
    public void setSex(String sex) {
        this.sex = sex;
    }

    // REQUIRES: given weight as positive double in kg
    // EFFECT: set the person's weight
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // REQUIRES: given height as positive double in cm
    // EFFECT: set the person's height
    public void setHeight(double height) {
        this.height = height;
    }

    // REQUIRES: given string in add or lose
    // EFFECT: set the person's requirement
    public void setRequire(String require) {
        this.require = require;
    }


    // EFFECT: return account id
    public int getId() {
        return id;
    }

    // EFFECT: return account owner name
    public String getName() {
        return name;
    }

    // EFFECT: return account owner name
    public int getAge() {
        return age;
    }

    // EFFECT: return account owner sex
    public String getSex() {
        return sex;
    }

    // EFFECT: return account owner weight
    public double getWeight() {
        return weight;
    }

    // EFFECT: return account owner height
    public double getHeight() {
        return height;
    }

    // EFFECT: return account owner needs
    public String getRequire() {
        return require;
    }

    public void addFood(Food f) {
        foodList.add(f);
    }

    public void removeFood(Food f) {
        foodList.remove(f);
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public int countCalories() {
        int sum = 0;
        for (Food i : foodList) {
            int calories = i.getCalories();
            sum = sum + calories;
        }
        return sum;
    }



}
