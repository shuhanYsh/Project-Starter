package model;

// Represent the data of the account (collect personal information)
public class Data {
    public int age;        // the account owner age
    public double weight;  // the account owner weight in kg
    public double height;  // the account owner height in cm
    public String require; // the account owner needs, add or lose weight

    public Data() {
        this.age = 0;
        this.weight = 0.0;
        this.height = 0.0;
        this.require = "";
    }

    // REQUIRES: given age as positive int
    // EFFECT: set the person's age
    public void setAge(int age) {
        this.age = age;
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

    // EFFECT: return account owner name
    public int getAge() {
//        if (!"".equals(age)) {
//
//        }
//        } else {
//            throw new NumberFormatException("Please insert your age!");
        return age;
    }

    // EFFECT: return account owner weight
    public double getWeight() {
//        if (!"".equals(weight)) {
        return weight;
//        } else {
//            throw new NullPointerException("Please insert your weight!");
//        }
    }

    // EFFECT: return account owner height
    public double getHeight() {
//        if (!"".equals(height)) {
        return height;
//        } else {
//            throw new NullPointerException("Please insert your height!");
//        }
    }

    // EFFECT: return account owner needs
    public String getRequire() {
//        if (require != null && !"".equals(require)) {
        return require;
//        } else {
//            throw new NullPointerException("Please insert your personal needs!");
//        }
    }

}
