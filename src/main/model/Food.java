package model;

public class Food {
    public String name;  // food name
    public int calories; // food calories in 100g per kcal
    public int quality;  // food quality in gram

    // REQUIRES: calories as positive int
    // MODIFIES: this
    // EFFECTS: set food name and calories
    public Food(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    // EFFECTS: returns food name
    public String getName() {
        return name;
    }

    // EFFECTS: returns Calories in kcal of the food per 100g
    public int getCalories() {
        return calories;
    }

    // MODIFIES: this
    // EFFECTS: set food name
    public void setName(String name) {
        this.name = name;
    }

    // REQUIRES: calories as positive int
    // MODIFIES: this
    // EFFECTS: set food calories
    public void setCalories(int calories) {
        this.calories = calories;
    }

}
