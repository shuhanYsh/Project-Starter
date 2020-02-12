package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {
    private Account testAccount;
    Food testFood1;
    Food testFood2;

    @BeforeEach
    void runBefore() {
        testAccount = new Account(007, "wjp");
        testFood1 = new Food("food1",100);
        testFood2 = new Food("food2", 250);
    }

    @Test
    void testConstructor(){
        testAccount = new Account(007, "wjp");

    }

    @Test
    void testSetAge(){
        testAccount.setAge(20);
        assertEquals(20, testAccount.getAge());
    }

    @Test
    void testSetSex(){
        testAccount.setSex("male");
        assertEquals("male", testAccount.getSex());
    }

    @Test
    void testSetWeight(){
        testAccount.setWeight(65.0);
        assertEquals(65.0, testAccount.getWeight());
    }

    @Test
    void testSetHeight(){
        testAccount.setHeight(175.5);
        assertEquals(175.5, testAccount.getHeight());
    }

    @Test
    void testSetRequire(){
        testAccount.setRequire("add");
        assertEquals("add", testAccount.getRequire());
    }

    @Test
    void testGetId() {
        assertEquals(007, testAccount.getId());
    }

    @Test
    void testGetName(){
        assertEquals("wjp", testAccount.getName());
    }

    @Test
    void testGetAge(){
        testAccount.setAge(20);
        assertEquals(20, testAccount.getAge());
    }

    @Test
    void testGetSex(){
        testAccount.setSex("male");
        assertEquals("male", testAccount.getSex());
    }

    @Test
    void testGetWeight(){
        testAccount.setWeight(65.0);
        assertEquals(65.0, testAccount.getWeight());
    }

    @Test
    void testGetHeight(){
        testAccount.setHeight(175.5);
        assertEquals(175.5, testAccount.getHeight());
    }

    @Test
    void testGetRequire(){
        testAccount.setRequire("add");
        assertEquals("add", testAccount.getRequire());

    }

    @Test
    void testAddFood() {
        testAccount.addFood(testFood1);
        assertEquals(testFood1, testAccount.getFoodList().get(0));
    }

    @Test
    void testRemoveFood() {
        testAccount.addFood(testFood1);
        testAccount.addFood(testFood1);
        testAccount.removeFood(testFood1);
        assertEquals(1, testAccount.getFoodList().size());
    }

    @Test
    void testGetFoodList() {
        testAccount.getFoodList().isEmpty();
        testAccount.addFood(testFood1);
        ArrayList testList = new ArrayList();
        testList.add(testFood1);
        assertEquals(testList, testAccount.getFoodList());
    }



    @Test
    void testCountCalories() {
        testAccount.addFood(testFood1);
        testAccount.addFood(testFood2);
        assertEquals(350, testAccount.countCalories());
    }
}