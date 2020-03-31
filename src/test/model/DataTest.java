package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DataTest {
    private Data testData;

    @BeforeEach
    void runBefore() {
        testData = new Data();
    }

    @Test
    void testConstructor() {
        testData = new Data();
    }

    @Test
    void testSetAge() {
        testData.setAge(20);
        assertEquals(20 , testData.getAge());
    }

    @Test
    void testSetHeight() {
        testData.setHeight(175);
        assertEquals(175 , testData.getHeight());
    }
    
    @Test
    void testSetWeight() {
        testData.setWeight(65);
        assertEquals(65 , testData.getWeight());
    }

    @Test
    void testSetRequire() {
        testData.setRequire("add");
        assertEquals("add" , testData.getRequire());
    }

}
