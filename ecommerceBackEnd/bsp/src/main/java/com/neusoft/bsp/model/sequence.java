package com.neusoft.bsp.model;

public class sequence {
    private String name;

    private Integer currentValue;

    private Integer increment;

    private String initial;

    public sequence(String name, Integer currentValue, Integer increment, String initial) {
        this.name = name;
        this.currentValue = currentValue;
        this.increment = increment;
        this.initial = initial;
    }

    public sequence() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }
}