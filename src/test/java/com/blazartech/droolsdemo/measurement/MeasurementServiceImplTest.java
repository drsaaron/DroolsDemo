/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.blazartech.droolsdemo.measurement;

import java.util.Set;
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
 * @author aar1069
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {
    MeasurementServiceImplTest.MeasurementServiceImplTestConfiguration.class
})
public class MeasurementServiceImplTest {
    
    private static final Logger logger = LoggerFactory.getLogger(MeasurementServiceImplTest.class);
    
    @Configuration
    public static class MeasurementServiceImplTestConfiguration {
        
        @Bean
        public MeasurementServiceImpl instance() {
            return new MeasurementServiceImpl();
        }
    }
    
    @Autowired
    private MeasurementServiceImpl instance;
    
    public MeasurementServiceImplTest() {
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
     * Test of getControlSet method, of class MeasurementServiceImpl.
     */
    @Test
    public void testGetControlSet() {
        logger.info("getControlSet");
        
        Set<String> expResult = null;
        Set<String> result = instance.getControlSet();

        assertEquals(expResult, result);
    }
    
}
