package model;

public class Account {
    public int id;         // the account id
    public int age;        // the account owner age
    public double weight;  // the account owner weight in kg
    public double height;  // the account owner height in cm
    public String name;    // the account owner name
    public String sex;     // the account owner physical sex, male or female
    public String require; // the account owner needs, add or lose weight

    // EFFECT: set the account based on the person's name, sex, weight,height, and require, and assigned id
    public Account(int id, String name,String sex, double weight, double height, String require) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
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

}
