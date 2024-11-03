package com.demo.springboot_cache.test;

public class SingletonDataSource {

    private static SingletonDataSource instance;
    private SingletonDataSource(){
        System.out.println("singleton datasource constructor");
    }

    public static SingletonDataSource getInstance(){
        if(instance == null){
            return new SingletonDataSource();
        }
        return instance;
    }

}
