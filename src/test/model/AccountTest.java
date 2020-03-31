package model;

import exception.InvalidInformationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AccountTest {
    private Account testAccount;



    @BeforeEach
    void runBefore() throws InvalidInformationException {
        testAccount = new Account("wjp", "m");

    }

    @Test
    void testConstructor() {
        testAccount = new Account( "wjp", "m");
    }


    @Test
    void testGetEmptyName(){
        Account testAccount1 = new Account( "", "m");
        try {
            assertEquals("Please insert your name!", testAccount1.getName());
            fail("should throw this exception!");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void testGetNullName(){
        Account testAccount1 = new Account( null, "m");
        try {
            assertEquals("Please insert your name!", testAccount1.getName());
            fail("should throw this exception!");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void testGetName(){
        Account testAccount1 = new Account( "wjp", "m");
        try {
            assertEquals("wjp", testAccount1.getName());
        } catch (NullPointerException e) {
            fail("should not throw this exception!");
        }
    }

    @Test
    void testGetInvalidSex() {
        Account testAccount2 = new Account( "wjp", "s");
        try{
            assertEquals("Invalid Sex !", testAccount2.getSex());
            fail("should throw this exception!");
        } catch (InvalidInformationException e){

        }
    }

    @Test
    void testGetSexMale() {
        Account testAccount2 = new Account( "wjp", "m");
        try{
            assertEquals("m", testAccount2.getSex());
        } catch (InvalidInformationException e){
            fail("should not throw this exception!");
        }
    }

    @Test
    void testGetSexFemale() {
        Account testAccount2 = new Account( "ysh", "f");
        try{
            assertEquals("f", testAccount2.getSex());
        } catch (InvalidInformationException e){
            fail("should not throw this exception!");
        }
    }

    @Test
    void testModifyName(){
        testAccount.modifyName("ysh");
        assertEquals("ysh", testAccount.getName());
    }

    @Test
    void testModifySex() throws InvalidInformationException {
        testAccount.modifySex("f");
        assertEquals("f", testAccount.getSex());
    }


//    @Test
//    void testGetData() {
//        testAccount.getData();
//    }




}