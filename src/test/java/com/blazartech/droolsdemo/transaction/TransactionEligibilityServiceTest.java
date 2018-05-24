/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.transaction;

import java.math.BigDecimal;
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
    TransactionEligibilityDemoConfiguration.class,
    TransactionEligibilityServiceTest.TransactionEligibilityServiceTestConfiguration.class
})
public class TransactionEligibilityServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(TransactionEligibilityServiceTest.class);
    
    @Configuration
    static class TransactionEligibilityServiceTestConfiguration {
        
        @Bean
        public TransactionEligibilityService getTransactionEligibilityService() {
            return new TransactionEligibilityService();
        }
    }
    
    @Autowired
    private TransactionEligibilityService service;
    
    public TransactionEligibilityServiceTest() {
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

    private static final String COMMISSION_FR = "0ABCDE";
    private static final String INELIGIBLE_COMMISSION_FR = "0Z7891";
    
    /**
     * Test of determineEligibility method, of class TransactionEligibilityService.
     */
    @Test
    public void testCommissionEligibility_EligibleFR() {
        logger.info("testCommissionEligibility_EligibleFR");
        
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("50000"));
        transaction.setCompensationProgram(1);
        transaction.setDsbNumber(COMMISSION_FR);
        transaction.setEffectiveDate(java.sql.Date.valueOf("2018-01-01"));
        transaction.setId(1L);
        
        Eligibility result = service.determineEligibility(transaction);
        
        assertTrue(result.getEligibleToCalculate());
        assertTrue(result.getEligibleToDistribute());
        assertTrue(result.getEligibleToProduce());
    }
    
    @Test
    public void testCommissionEligibility_ineligibleFR() {
        logger.info("testCommissionEligibility_ineligibleFR");
        
        Transaction transaction = new Transaction();
        transaction.setAmount(new BigDecimal("50000"));
        transaction.setCompensationProgram(1);
        transaction.setDsbNumber(INELIGIBLE_COMMISSION_FR);
        transaction.setEffectiveDate(java.sql.Date.valueOf("2018-01-01"));
        transaction.setId(1L);
        
        Eligibility result = service.determineEligibility(transaction);
        
        assertFalse(result.getEligibleToCalculate());
        assertTrue(result.getEligibleToDistribute());
        assertFalse(result.getEligibleToProduce());
    }
}
