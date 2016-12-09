package com.jqchen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class CalculatorTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
        Assert.assertEquals("test", new Calculator().get());
    }
}