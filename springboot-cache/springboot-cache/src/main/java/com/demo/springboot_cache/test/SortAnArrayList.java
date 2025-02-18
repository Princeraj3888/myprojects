package com.demo.springboot_cache.test;

import java.util.List;
import java.util.stream.Collectors;

public class SortAnArrayList {

    public static void main(String []args){
        List<Integer> integerList = List.of(6, 5, 7, 4 , 3, 1, 2);

        System.out.println(integerList);

        List<Integer> sortedList = integerList.stream().sorted().collect(Collectors.toList());

        System.out.println(sortedList);

        int median = 0;

        if(sortedList.size() % 2 == 1){
            median = sortedList.get(sortedList.size()/2);
        }

        System.out.println("median: "+median);
    }
}
