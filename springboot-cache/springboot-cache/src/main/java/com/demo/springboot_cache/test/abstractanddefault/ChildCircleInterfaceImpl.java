package com.demo.springboot_cache.test.abstractanddefault;

public class ChildCircleInterfaceImpl implements CircleInterface{

    private String color;

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }
}
