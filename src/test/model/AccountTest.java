package model;

import exception.InvalidInformationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AccountTest {
    private Account testAccount;


    Food testFood1;
    Food testFood2;

    @BeforeEach
    void runBefore() throws InvalidInformationException {
        testAccount = new Account( "wjp", "m");
        testFood1 = new Food("food1",100);
        testFood2 = new Food("food2", 250);
    }

    @Test
    void testConstructor() {
        testAccount = new Account( "wjp", "m");
    }


    @Test
    void testGetName(){
        try {
            assertEquals("wjp", testAccount.getName());
        } catch (NullPointerException e) {
            fail("should not throw this exception!");
        }

    }


    @Test
    void testGetSex() throws InvalidInformationException {
        assertEquals("m", testAccount.getSex());
    }


    @Test
    void testAddFood() {
        testAccount.addFood(testFood1,100);
        testAccount.addFood(testFood2,100);
    }

    @Test
    void testGetTotalNumberOfFood() {
        testAccount.addFood(testFood1,100);
        testAccount.addFood(testFood2,100);
        assertEquals(2, testAccount.getTotalNumberOfFood());
    }

    @Test
    void testGetTotalQuantityOfFood()  {
        assertEquals(0, testAccount.getTotalQuantityOfFood(testFood1));
        testAccount.addFood(testFood1,100);
        testAccount.addFood(testFood2,100);
        assertEquals(100, testAccount.getTotalQuantityOfFood(testFood1));
        testAccount.addFood(testFood2,100);
        assertEquals(200, testAccount.getTotalQuantityOfFood(testFood2));
    }

    @Test
    void testGetData() {
        testAccount.getData();
    }




}