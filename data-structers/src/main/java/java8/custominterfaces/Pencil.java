package java8.custominterfaces;

import java.lang.annotation.*;

@print(times = 3)
public class Pencil {

    public void write(){
        System.out.println("i am writing");
    }

    public void displayBrandName(){
        System.out.println("i am non branded");
    }
    @Deprecated
    public void sharpening(){}
}

@print(times = 2)
class Natraj extends Pencil{
    @Override
    public void write(){
        System.out.println("natraj pencil is writing");
    }
}

class Apsara extends Pencil{

    @Override
    @dontPrint
    public void displayBrandName(){
        System.out.println("apsara pencil brand");
    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface dontPrint{

}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@interface print{
    int times() default 1;
}
