package java8.practice.firststage;

import java8.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class Client {

    public static void main(String[] args){
        Calculator c = (int a, int b) -> {return a*b;};
        //System.out.println("multiplication: "+ c.solve(2, 7));

        Calculator addition = (a, b) -> {return a + b;};
        //System.out.println("addition: "+addition.solve(4, 9));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);
        treeMap.put(18, 1);
        treeMap.put(2, 5);
        treeMap.put(5, 78);
        treeMap.put(1, 52);
        treeMap.put(45, 23);
        //System.out.println(treeMap);

        // CONSUMER takes one input and can modify it, does not return value
        //PREDICATE takes one input, can modify it and returns boolean value
        //FUNCTION takes one T input, can modify it and return R output
        //SUPPLIER takes no input and returns T output

//        Consumer<Integer> consume = (n) -> System.out.println(n);
//        consume.accept(29);

        Predicate<Integer> numberPredicate = (n) -> n%2==0;
        System.out.println(numberPredicate.test(17));

        Student student1 = new Student();
        student1.setAge(23); student1.setName("hanumana");
        Predicate<Student> studentPredicate = (student)->{
            if(student.getName().length() % 2 == 0){
                return true;
            }
            return false;
        };
        System.out.println(studentPredicate.test(student1));

        Function<Integer, String> function1 = (n) -> {
            if(n%2 == 0){
                return "EVEN";
            }
            return "ODD";
        };
        System.out.println(function1.apply(26));

        Supplier supplier = () -> {
            Student s2 = new Student();
            s2.setName("rahul");
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            s2.setAge(25);
            return s2;
        };
        Student s3 = (Student) supplier.get();
        System.out.println(s3);
    }
}
