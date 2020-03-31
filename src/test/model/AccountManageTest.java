package model;

import exception.InvalidInformationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AccountManageTest {
    private AccountManage testAccountManage;


    @BeforeEach
    void runBefore(){
        testAccountManage = new AccountManage("wjp", "m");
        testAccountManage.getData().setAge(20);
        testAccountManage.getData().setHeight(175);
        testAccountManage.getData().setWeight(65);
        testAccountManage.getData().setRequire("add");
        Food testFood1 = new Food("apple", 30);
        Food testFood2 = new Food("beef", 107);
//        testAccountManage.addFood(testFood1, 50);
//        testAccountManage.addFood(testFood2, 500);
    }

    @Test
    void testConstructor(){
        Account testAccountManage = new Account("wjp", "m");
    }

    @Test
    void testMaleBasalMetabolism()  {
        try{
            assertEquals(1695.5,testAccountManage.basalMetabolism());
        } catch (IOException e){
            fail("should not throw this exception!");
        }
    }

    @Test
    void testFemaleBasalMetabolism(){
        try{
            AccountManage testAccountManage2 = new AccountManage("ysh", "f");
            testAccountManage2.getData().setAge(19);
            testAccountManage2.getData().setHeight(160);
            testAccountManage2.getData().setWeight(53);
            testAccountManage2.getData().setRequire("lose");
            assertEquals(1362.5, testAccountManage2.basalMetabolism());
        } catch (IOException e){
            fail("should not throw this exception!");
        }
    }

    @Test
    void testInvalidSexBasalMetabolism(){
        try{
            AccountManage testAccountManage2 = new AccountManage("ysh", "s");
            testAccountManage2.getData().setAge(19);
            testAccountManage2.getData().setHeight(160);
            testAccountManage2.getData().setWeight(53);
            testAccountManage2.getData().setRequire("lose");
            assertEquals("Invalid Sex!", testAccountManage2.basalMetabolism());
            fail("should throw this exception!");
        } catch (IOException e){

        }
    }

//    @Test
//    void testCountIn() {
//        assertEquals(550.0, testAccountManage.countIntakeCalories());
//    }
//
//    @Test
//    void testTotalCal() throws IOException {
//        assertEquals(-1145.5, testAccountManage.dailyCalories());
//    }

    @Test
    void testJsonToString(){
        String s = testAccountManage.jsonToString();
        assertEquals("{\"needs\":\"add\",\"weight\":65,\"age\":20,\"height\":175}",s);
    }

    @Test
    void testSetData(){
        Data testData = new Data();
        testAccountManage.setData(testData);
        assertEquals(testData, testAccountManage.getData());
    }


}
