package com.demo.springboot_cache.test.abstractanddefault;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractCircleClass {

    private String color;
    private List<String> allowedColors = Arrays.asList("RED", "GREEN", "BLUE");

    public boolean isValid(){
        if(allowedColors.contains(getColor())){
            return true;
        }else{
            return false;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
