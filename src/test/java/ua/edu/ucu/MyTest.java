package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class MyTest {

    private IntStream intStream;
    private IntStream intStream2;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        int[] intArr1 = {};
        intStream = AsIntStream.of(intArr);
        intStream2 = AsIntStream.of(intArr1);
    }

    @Test
    public void testMax() {
        assertEquals(intStream.max(), 3, 0.00001);


    }

    @Test
    public void testMin() {
        assertEquals(intStream.min(), -1, 0.0000001);
    }

    @Test
    public void testAvg() {
        assertEquals(intStream.average(), 1, 0.0000001);
    }

    @Test
    public void testCount() {
        assertEquals(intStream.count(), 5, 0.000001);
    }

    @Test
    public void testSum() {
        assertEquals(intStream.sum(), 5, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void maxZeroLen() { //no need to also check other(min, average, sum)
        int mx = intStream2.max();
    }


    @Test
    public void countZeroLen() {
        assertEquals(intStream2.count(), 0, 0.00001);
    }
}
