package com.demo.springboot_cache.test;

import java.util.Arrays;
import java.lang.Number;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ArrayProcessing {

    public static void main(String args[]){

        int [] array = {7,0,9,4,0,7,0};

        processArray(array);
    }

    private static void processArray(int[] array) {

        int n = array.length;
        int writeIndex = 0;
        int temp = 0;

        for(int readIndex=0; readIndex<n; readIndex++){

            if(array[readIndex]!=0){
                if(readIndex!=writeIndex){
                    temp = array[readIndex];
                    array[writeIndex] = array[readIndex];
                    array[readIndex] = temp;
                }
                writeIndex++;
            }

        }

        for(int i =writeIndex; i<n; i++){
            array[i] = 0;
        }

        System.out.println(Arrays.toString(array));
    }
}
