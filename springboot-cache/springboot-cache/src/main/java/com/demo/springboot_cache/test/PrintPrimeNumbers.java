package com.demo.springboot_cache.test;

import java.util.Scanner;

public class PrintPrimeNumbers {

    public static void main(String args[]){
        //Scanner sc = new Scanner();

        int number = 7;
        for(int i=2; i<number; i++){
            if(printPrimeNumbers(i)){
                System.out.println("given number is prime number: "+i);
            }else{
                //System.out.println("given number is not prime number: "+i);
            }
        }

    }

    public static boolean printPrimeNumbers(int number) {
        if (number == 1 || number == 0) {
            System.out.println("given number is not prime number");
            return false;
        }
            for (int i = 2; i < number; i++) {
                    if (number % i == 0) {
                        return false;
                    }
            }
            return true;
        }

}
