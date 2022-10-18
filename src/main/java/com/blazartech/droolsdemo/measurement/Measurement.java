/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.droolsdemo.measurement;

/**
 *
 * @author aar1069
 */
public class Measurement {
    
    private String id;
    private String val;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String color) {
        this.val = color;
    }

    @Override
    public String toString() {
        return "Measurement{" + "id=" + id + ", val=" + val + '}';
    }

    public Measurement(String id, String val) {
        this.id = id;
        this.val = val;
    }
    
    
}
