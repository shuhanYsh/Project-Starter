package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {
    private Account testAccount;

    @BeforeEach
    void runBefore() {
        testAccount = new Account(007, "wjp", "male", 65, 175, "add");

    }

    @Test
    void testConstructor(){
        testAccount = new Account(007, "wjp", "male", 65, 175, "add");

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
    void testGetSex(){
        assertEquals("male", testAccount.getSex());
    }

    @Test
    void testGetWeight(){
        assertEquals(65, testAccount.getWeight());
    }

    @Test
    void testGetHeight(){
        assertEquals(175, testAccount.getHeight());
    }

    @Test
    void testGetRequire(){
        assertEquals("add", testAccount.getRequire());

    }
}
