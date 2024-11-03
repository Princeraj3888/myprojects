package com.demo.springboot_cache.test.abstractanddefault;

public class AbstractChildCircleClass extends AbstractCircleClass{

    public static void main(String args[]){
        AbstractCircleClass circleClass = new AbstractChildCircleClass();
        circleClass.setColor("RED");
        System.out.println(circleClass.isValid());

        ChildCircleInterfaceImpl impl = new ChildCircleInterfaceImpl();
        impl.setColor("BLUE");
        System.out.println(impl.isValid());
    }
}
