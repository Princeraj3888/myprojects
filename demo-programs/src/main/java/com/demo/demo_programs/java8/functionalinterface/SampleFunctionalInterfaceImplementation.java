package com.demo.demo_programs.java8.functionalinterface;

public class SampleFunctionalInterfaceImplementation {

    public static void main(String args[]){

        MySampleFunctionalInterface functionalInterface = () -> {

            return "i am going to display some data using function interface method";
        };

        System.out.println(functionalInterface.displaySomeData());

        Runnable runnable = () ->{
            System.out.println("this is my runnable implementation");
        };
        runnable.run();

    }
}

