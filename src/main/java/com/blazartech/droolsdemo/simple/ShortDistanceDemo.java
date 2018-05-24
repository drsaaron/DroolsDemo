/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.droolsdemo.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * a demo of http://www.baeldung.com/drools-spring-integration
 *
 * @author AAR1069
 */
@Component
public class ShortDistanceDemo implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ShortDistanceDemo.class);

    @Autowired
    private TaxiFareCalculatorService taxiFareCalculatorService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("running short distance demo");

        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(false);
        taxiRide.setDistanceInMile(9L);
        Fare rideFare = new Fare();
        Long totalCharge = taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
        
        logger.info("total charge = " + totalCharge);
    }

}
