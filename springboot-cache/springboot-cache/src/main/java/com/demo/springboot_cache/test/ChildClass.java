package com.demo.springboot_cache.test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ChildClass extends ParentClass{
    @Override
    public void openFile(int j) throws FileNotFoundException {
        System.out.println("Child test");
    }
    //the below code is failing because of violating overriding rules
    /** @Override
    protected void openFile() throws IOException{
        System.out.println("child test");
    }*/
}
