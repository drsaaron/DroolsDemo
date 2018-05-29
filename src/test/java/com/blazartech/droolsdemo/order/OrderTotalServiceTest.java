/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.order;

import java.util.ArrayList;
import java.util.Collection;
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
    OrderDemoConfiguration.class,
    OrderTotalServiceTest.OrderTotalServiceTestConfiguration.class
})
public class OrderTotalServiceTest {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderTotalServiceTest.class);
    
    @Configuration
    static class OrderTotalServiceTestConfiguration {
        
        @Bean
        public OrderTotalService getOrderTotalService() {
            return new OrderTotalService();
        }
    }
    
    @Autowired
    private OrderTotalService service;
    
    public OrderTotalServiceTest() {
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
     * Test of determineOrderTotal method, of class OrderTotalService.
     */
    @Test
    public void testDetermineOrderTotal_noDiscount() {
        logger.info("determineOrderTotal_noDiscount");
        
        Order order = new Order();
        Collection<OrderItem> items = new ArrayList<>();
        order.setOrderItems(items);
        
        OrderItem item1 = new OrderItem();
        item1.setValue(50);
        items.add(item1);
        item1.setOrder(order);
        
        OrderItem item2 = new OrderItem();
        item2.setValue(25);
        items.add(item2);
        item2.setOrder(order);

        service.determineOrderTotal(order);

        assertFalse(order.isDiscountApplied());
    }
    
    @Test
    public void testDetermineOrderTotal_discount() {
        logger.info("determineOrderTotal_discount");
        
        Order order = new Order();
        Collection<OrderItem> items = new ArrayList<>();
        order.setOrderItems(items);
        
        OrderItem item1 = new OrderItem();
        item1.setValue(50);
        items.add(item1);
        item1.setOrder(order);
        
        OrderItem item2 = new OrderItem();
        item2.setValue(25);
        items.add(item2);
        item2.setOrder(order);
        
        OrderItem item3 = new OrderItem();
        item3.setValue(35);
        items.add(item3);
        item3.setOrder(order);

        service.determineOrderTotal(order);

        assertTrue(order.isDiscountApplied());
        assertEquals(99f, order.getTotal(), 0.0);
    }
    
}
