package com.demo.springboot_cache.test;

import java.math.BigInteger;

public class FactorialOfNumber {

    public static BigInteger factorialOfNumber(int number){
        BigInteger fac = new BigInteger("1");

        for(int i=2; i<=number; i++){
            fac = fac.multiply(BigInteger.valueOf(i));
        }

        return fac;
    }
}
