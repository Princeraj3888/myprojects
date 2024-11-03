package com.demo.springboot_cache.test.abstractanddefault;

import java.util.Arrays;
import java.util.List;

public interface CircleInterface {
    List<String> allowedColors = Arrays.asList("RED", "BLUE", "GREEN");

    String getColor();

    public default boolean isValid(){
        if(allowedColors.contains(getColor())){
            return true;
        }else{
            return false;
        }
    }
}
