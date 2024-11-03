package com.demo.springboot_cache.test;

import java.util.Arrays;

public class FindFirstAndLastDigit {


    public static void main(String args[]){

        int num = 234;

        //handle negative numbers by taking absolute value
        int absNumber = Math.abs(num);

        int lastDigit = absNumber % 10;
        System.out.println("last digit: "+lastDigit);

        int firstDigit = num;

        while(firstDigit>=10){
            firstDigit /=10;
        }

        System.out.println("first digit: "+firstDigit);

    }



}
