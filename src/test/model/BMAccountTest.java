package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BMAccountTest {
    private BMAccount testBMAccount;


    @BeforeEach
    void runBefore(){
        testBMAccount = new BMAccount("wjp", "m");
        testBMAccount.getData().setAge(20);
        testBMAccount.getData().setHeight(175);
        testBMAccount.getData().setWeight(65);
        testBMAccount.getData().setRequire("add");
        Food testFood1 = new Food("apple", 30);
        Food testFood2 = new Food("beef", 107);
//        testBMAccount.addFood(testFood1, 50);
//        testBMAccount.addFood(testFood2, 500);
    }

    @Test
    void testConstructor(){
        Account testAccountManage = new Account("wjp", "m");
    }

    @Test
    void testMaleBasalMetabolism()  {
        try{
            assertEquals(1695.5, testBMAccount.basalMetabolism());
        } catch (IOException e){
            fail("should not throw this exception!");
        }
    }

    @Test
    void testFemaleBasalMetabolism(){
        try{
            BMAccount testAccountManage2 = new BMAccount("ysh", "f");
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
            BMAccount testAccountManage2 = new BMAccount("ysh", "s");
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
//        assertEquals(550.0, testBMAccount.countIntakeCalories());
//    }
//
//    @Test
//    void testTotalCal() throws IOException {
//        assertEquals(-1145.5, testBMAccount.dailyCalories());
//    }

    @Test
    void testJsonToString() throws IOException {
        String s = testBMAccount.jsonToString();
        assertEquals("{\"needs\":\"add\",\"sex\":\"m\",\"name\":\"wjp\",\"weight\":65,\"age\":20,\"height\":175}",s);
    }

    @Test
    void testGetData() {
        testBMAccount.getData();
    }

    @Test
    void testSetData(){
        Data testData = new Data();
        testBMAccount.setData(testData);
        assertEquals(testData, testBMAccount.getData());
    }


}
