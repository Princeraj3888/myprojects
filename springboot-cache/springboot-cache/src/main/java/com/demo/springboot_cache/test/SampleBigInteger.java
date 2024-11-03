package com.demo.springboot_cache.test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SampleBigInteger {

    public static void main(String args[]){

        BigInteger a = BigInteger.valueOf(789);
        BigInteger b = BigInteger.valueOf(456);

        BigInteger add = a.add(b);
        BigInteger mul = a.multiply(b);

        System.out.println("add: "+add+" mul: "+mul);

        BigInteger c = new BigInteger("4797946546513233213232");
        BigInteger d = new BigInteger("13203546516165616546546546");

        BigInteger e = c.multiply(d);

        BigInteger f = c.multiply(a);
        System.out.println("e multiply: "+e+" f multiply: "+f);

        System.out.println(FactorialOfNumber.factorialOfNumber(5));

        Double d1 = 0.03;
        Double d2 = 0.04;

        Double dsub = d2 - d1;
        System.out.println("substract of double is: "+dsub);

        BigDecimal b1 = BigDecimal.valueOf(0.03);
        BigDecimal b2 = BigDecimal.valueOf(0.04);
        BigDecimal b3 = b2.subtract(b1);
        System.out.println("subtract of bigdecimal is: "+b3);

    }
}
