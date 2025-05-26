package com.demo.demo_programs.java8.interview.primenumber;

public class PrimeNumberDemo {

    public static void main(String[] args){
        int target = 100;
        for(int i=2; i<target; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
