package com.job.calculator;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Test for the Buffer class
 */
public class BufferTest {

    @Test
    public void save() throws Exception {
        Buffer buffer = new Buffer(5);
        Field result = Buffer.class.getDeclaredField("mData");
        result.setAccessible(true);

        buffer.save(0);
        assertEquals(0.0, result.getDouble(buffer), 0.000001);

        buffer.save(132);
        assertNotEquals(123.0, result.getDouble(buffer), 0.000001);

        buffer.save(-132);
        assertEquals(-132.0, result.getDouble(buffer), 0.000001);

        buffer.save(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, result.getDouble(buffer), 0.000001);

        buffer.save(Double.MIN_VALUE);
        assertEquals(Double.MIN_VALUE, result.getDouble(buffer), 0.000001);

        buffer.save(Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, result.getDouble(buffer), 0.000001);

        buffer.save(Double.NEGATIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, result.getDouble(buffer), 0.000001);
    }

    @Test
    public void read() throws Exception {
        Buffer buffer = new Buffer(5);
        Field result = Buffer.class.getDeclaredField("mData");
        result.setAccessible(true);

        result.set(buffer, 0);
        assertEquals(0.0, buffer.read(), 0.000001);

        result.set(buffer, 132);
        assertNotEquals(123.0, buffer.read(), 0.000001);

        result.set(buffer, -132);
        assertEquals(-132.0, buffer.read(), 0.000001);

        result.set(buffer, Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, buffer.read(), 0.000001);

        result.set(buffer, Double.MIN_VALUE);
        assertEquals(Double.MIN_VALUE, buffer.read(), 0.000001);

        result.set(buffer, Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, buffer.read(), 0.000001);

        result.set(buffer, Double.NEGATIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, buffer.read(), 0.000001);
    }

    @Test
    public void clear() throws Exception {
        Buffer buffer = new Buffer(5);
        Field result = Buffer.class.getDeclaredField("mData");
        result.setAccessible(true);

        result.set(buffer, 0);
        buffer.clear();
        assertEquals(0.0, result.getDouble(buffer), 0.000001);

        result.set(buffer, 132);
        buffer.clear();
        assertNotEquals(132, result.getDouble(buffer), 0.000001);

        result.set(buffer, -132);
        buffer.clear();
        assertEquals(0.0, result.getDouble(buffer), 0.000001);

        result.set(buffer, Double.MAX_VALUE);
        buffer.clear();
        assertNotEquals(Double.MAX_VALUE, result.getDouble(buffer), 0.000001);

        result.set(buffer, Double.MIN_VALUE);
        buffer.clear();
        assertEquals(0, result.getDouble(buffer), 0.000001);

        result.set(buffer, Double.POSITIVE_INFINITY);
        buffer.clear();
        assertEquals(0, result.getDouble(buffer), 0.000001);

        result.set(buffer, Double.NEGATIVE_INFINITY);
        buffer.clear();
        assertEquals(0, result.getDouble(buffer), 0.000001);
    }

    @Test
    public void plus() throws Exception {
        Buffer buffer = new Buffer(5);
        Field result = Buffer.class.getDeclaredField("mData");
        result.setAccessible(true);

        result.set(buffer, 0);
        buffer.plus(4);
        assertEquals(4.0, result.getDouble(buffer), 0.000001);

        result.set(buffer, 132);
        buffer.plus(0);
        assertEquals(132, result.getDouble(buffer), 0.000001);

        result.set(buffer, -132);
        buffer.plus(132);
        assertEquals(0.0, result.getDouble(buffer), 0.000001);

        result.set(buffer, Double.MAX_VALUE);
        buffer.plus(1);
        assertEquals(Double.MAX_VALUE, result.getDouble(buffer), 0.000001);

        result.set(buffer, Double.MIN_VALUE);
        buffer.plus(0);
        assertEquals(Double.MIN_VALUE, result.getDouble(buffer), 0.000001);
    }

    @Test
    public void minus() throws Exception {
        Buffer buffer = new Buffer(5);
        Field result = Buffer.class.getDeclaredField("mData");
        result.setAccessible(true);

        result.set(buffer, 0);
        buffer.minus(4);
        assertEquals(-4.0, result.getDouble(buffer), 0.000001);

        result.set(buffer, 132);
        buffer.minus(0);
        assertEquals(132, result.getDouble(buffer), 0.000001);

        result.set(buffer, -132);
        buffer.minus(-132);
        assertEquals(0.0, result.getDouble(buffer), 0.000001);

        result.set(buffer, Double.MAX_VALUE);
        buffer.minus(1);
        assertEquals(Double.MAX_VALUE, result.getDouble(buffer), 0.000001);

        result.set(buffer, Double.MIN_VALUE);
        buffer.minus(0);
        assertEquals(Double.MIN_VALUE, result.getDouble(buffer), 0.000001);
    }

}