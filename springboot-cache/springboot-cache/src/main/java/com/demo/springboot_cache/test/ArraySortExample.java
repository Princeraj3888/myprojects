package com.demo.springboot_cache.test;

import java.util.Arrays;

public class ArraySortExample {

    public static void main(String args[]){
        int[] array = {7, 4, 5, 2, 0, 1, 9};

        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-1-i; j++){
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
