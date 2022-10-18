/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.droolsdemo.measurement;

import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
public class MeasurementDemo implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MeasurementDemo.class);
    
    @Autowired
    private MeasurementService measurementService;
    
    @Override
    public void run(String... args) throws Exception {
        logger.info("getting control set");
        Set<String> controlSet = measurementService.getControlSet();
        controlSet.forEach(s -> logger.info("control set: " + s));
    }
    
}
