package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodTest {
    private Food testFood;

    @BeforeEach
    void runBefore(){
        testFood = new Food("beef", 107);
    }

    @Test
    void testConstructor(){
        testFood = new Food("beef", 107);

    }

    @Test
    void testGetName() {
        assertEquals("beef", testFood.getName());
    }

    @Test
    void testGetCalories(){
        assertEquals(107, testFood.getCalories());
    }

    @Test
    void testSetName(){
        testFood.setName("pork");
        assertEquals("pork",testFood.getName());
    }

    @Test
    void testSetCalories(){
        testFood.setCalories(336);
        assertEquals(336, testFood.getCalories());
    }


}
