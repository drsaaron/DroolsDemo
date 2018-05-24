/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.sum;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author AAR1069
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
    SumConfiguration.class,
    SumServiceTest.SumServiceTestConfiguration.class
})
public class SumServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(SumServiceTest.class);
    
    @Configuration
    static class SumServiceTestConfiguration {
        
        @Bean
        public SumService getSumService() {
            return new SumService();
        }
    }
    
    @Autowired
    private SumService service;
    
    public SumServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addValues method, of class SumService.
     */
    @Test
    public void testAddSmallValuesValues() {
        logger.info("testAddSmallValues");
        
        int initialValue = 0;
        int addedValue = 90;
        
        Sum result = service.addValues(initialValue, addedValue);
        
        assertEquals(270, result.getValue());
    }
    
}
