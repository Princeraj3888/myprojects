package com.demo.springboot_cache.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapOperations {

    public static void main(String args[]){
        List<String> stringList = List.of("Ram", "Hanuman", "lakshman", "sita", "bharat");

        List<String> computedList  = stringList.stream().filter(str -> {
            if(str.length() % 3 == 0 || str.length() % 4 == 0) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        System.out.println(computedList);
    }
}
