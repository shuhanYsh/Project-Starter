package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        testAccountManage.addFood(testFood1, 50);
        testAccountManage.addFood(testFood2, 500);
    }

    @Test
    void testConstructor(){
        Account testAccountManage = new Account("wjp", "m");
    }

    @Test
    void testBasalMetabolism(){
        assertEquals(1695.5,testAccountManage.basalMetabolism());
    }

    @Test
    void testCountIn() {
        assertEquals(550.0, testAccountManage.countIntakeCalories());
    }

    @Test
    void testTotalCal() {
        assertEquals(-1145.5, testAccountManage.totalCalories());
    }

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
