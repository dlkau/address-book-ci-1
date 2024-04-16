package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class SumTest {
    Sum sum;

    @BeforeEach
    void setUp(){
        sum = new Sum();
    }

    @Test
    void testOnePlusOne(){
        int actual = sum.doSum(1,1);
    }

    @Test
    void testNegative(){
        int actual = sum.doSum(-3, -5);
        int expected = -8;
        assertEquals(expected, actual);
    }

    @Test
    void testLargeNumbers(){
        assertThrows(Exception.class, () -> sum.doSum(Integer.MAX_VALUE, 1));
    }
}