package com.thoughtworks.www.samples.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

/**
 * Created by leizeng on 22/02/2016.
 */
public class SimpleServiceImplTest {
    @InjectMocks
    SimpleServiceImpl simpleService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHelloWorld() throws Exception {
        String expectedHelloWorld = "Hello earth!";
        assertEquals(expectedHelloWorld, simpleService.helloWorld());
    }
}