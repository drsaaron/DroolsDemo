/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.droolsdemo.measurement;

import java.util.Set;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
public class MeasurementServiceImpl implements MeasurementService {

    private static Logger logger = LoggerFactory.getLogger(MeasurementServiceImpl.class);
    
    @Override
    public Set<String> getControlSet() {
        
        MeasurementUnit measurementUnit = new MeasurementUnit();
        RuleUnitInstance<MeasurementUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(measurementUnit);
        try {
            measurementUnit.getMeasurements().add(new Measurement("color", "red"));
            measurementUnit.getMeasurements().add(new Measurement("color", "green"));

            instance.fire();
        } finally {
            instance.close();
        }
        
        return instance.ruleUnitData().getControlSet();
    }
    
}
