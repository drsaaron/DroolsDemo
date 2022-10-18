/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.droolsdemo.measurement;

import java.util.HashSet;
import java.util.Set;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author aar1069
 */
public class MeasurementUnit implements RuleUnitData {
    
    private static final Logger logger = LoggerFactory.getLogger(MeasurementUnit.class);
    
    private final DataStore<Measurement> measurements;
    private final Set<String> controlSet = new HashSet<>();

    public MeasurementUnit() {
        this(DataSource.createStore());
    }

    public MeasurementUnit(DataStore<Measurement> measurements) {
        logger.info("creating unit with store " + measurements);
        this.measurements = measurements;
    }

    public DataStore<Measurement> getMeasurements() {
        return measurements;
    }

    public Set<String> getControlSet() {
        return controlSet;
    }
}
