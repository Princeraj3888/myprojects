package com.demo.springboot_cache.test;

public class TestSingleton {

    public static void main(String args[]){
        SingletonDataSource d1 = SingletonDataSource.getInstance();
        SingletonDataSource d2 = SingletonDataSource.getInstance();

        System.out.println("datasource: "+d1+" -- "+d2);
    }
}
