package java8.custominterfaces;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomInterfaceDemo {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //Pencil pencil = new Natraj();
        //pencil.sharpening();

        Natraj natraj = new Natraj();

        Apsara apsara = new Apsara();
        //apsara.displayBrandName();

        /*Method methods[] = apsara.getClass().getDeclaredMethods();
        for(Method method : methods){
            if(method.isAnnotationPresent(dontPrint.class)){
                method.invoke(apsara);
            }
        }*/

        if(natraj.getClass().isAnnotationPresent(print.class)){
            print annotation = natraj.getClass().getAnnotation(print.class);
            System.out.println("natraj times: "+annotation.times());
        }

        if(apsara.getClass().isAnnotationPresent(print.class)){
            print annotation = apsara.getClass().getAnnotation(print.class);
            System.out.println("apsara times: "+annotation.times());
        }else{
            System.out.println("times not present");
        }
    }
}
