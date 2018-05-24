/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.simple;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
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
    TaxiFareConfiguration.class,
    TaxiFareCalculatorServiceTest.TaxiFareCalculatorServiceTestConfiguration.class
})
public class TaxiFareCalculatorServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(TaxiFareCalculatorServiceTest.class);

    @Configuration
    static class TaxiFareCalculatorServiceTestConfiguration {

        @Bean
        public TaxiFareCalculatorService getTaxiFareCalculatorService() {
            return new TaxiFareCalculatorService();
        }
    }

    @Autowired
    private TaxiFareCalculatorService service;

    public TaxiFareCalculatorServiceTest() {
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

    @Test
    public void testDaytimeShortDistance() {
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(false);
        taxiRide.setDistanceInMile(9L);
        Fare rideFare = new Fare();
        Long totalCharge = service.calculateFare(taxiRide, rideFare);

        assertNotNull(totalCharge);
        assertEquals(Long.valueOf(70), totalCharge);
    }

    @Test
    public void testDaytimeLongDistance() {
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(false);
        taxiRide.setDistanceInMile(19L);
        Fare rideFare = new Fare();
        Long totalCharge = service.calculateFare(taxiRide, rideFare);

        assertNotNull(totalCharge);
        assertEquals(Long.valueOf(100), totalCharge);
    }
    
    @Test
    public void testNighttimeShortDistance() {
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(true);
        taxiRide.setDistanceInMile(9L);
        Fare rideFare = new Fare();
        Long totalCharge = service.calculateFare(taxiRide, rideFare);

        assertNull(totalCharge);
    }
}
