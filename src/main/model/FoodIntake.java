package model;

// Represents foodList ate by the person and the quantity of each food
public class FoodIntake {
    public Food foodItem;
    public int quantity;

    // EFFECTS: constructs a foodIntake list for the given food and quantity
    public FoodIntake(Food item, int quantity) {
        this.foodItem = item;
        this.quantity = quantity;
    }

    // EFFECTS: returns the quantity ate for the food
    public int getQuantity() {
        return quantity;
    }

    // EFFECTS: returns the food information for the food
    public Food getFoodItem() {
        return foodItem;
    }



    // REQUIRES: quantity > 0
    // MODIFIES: this
    // EFFECTS: adds amount to quantity of food on this foodItem
    public void addQuantity(int amount) {
        this.quantity += amount;
    }
}
