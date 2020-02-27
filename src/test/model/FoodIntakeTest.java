package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodIntakeTest {
    private FoodIntake testFoodIntake;
    private Food testFood1;

    @BeforeEach
    void runBefore(){
        testFood1 = new Food("beef", 107);
        testFoodIntake = new FoodIntake(testFood1, 100);
    }

    @Test
    void testConstructor(){
        testFoodIntake = new FoodIntake(testFood1, 100);
    }

    @Test
    void testGetQuality() {
        assertEquals(100, testFoodIntake.getQuantity());
    }

    @Test
    void testGetFoodItem(){
        assertEquals(testFood1, testFoodIntake.getFoodItem());
    }

    @Test
    void testAddQuantity() {
        testFoodIntake.addQuantity(100);
        assertEquals(200, testFoodIntake.getQuantity());
    }
}
