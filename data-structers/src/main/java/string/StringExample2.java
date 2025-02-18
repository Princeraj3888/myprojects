package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class StringExample2 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //  Write a Java program to count the number of words in a string using a hash map.
        //Input: "This this is is done by Saket Saket";
        //Output: {Saket=2, by=1, this=1, This=1, is=2, done=1}

        String str1 = "This this is is done by Saket Saket";
        String[] strList = str1.split(" ");

        List<String> stringList = new ArrayList<>();

        for(String str : strList ){
            stringList.add(str);
        }

        Map<String, Long> stringCountMap = stringList.stream()
        .collect(Collectors.groupingBy(str-> str, counting()));


        /*Map<String, Integer> map = new HashMap<>();

        for(String st : stringList){
            if(map.get(st)!=null){
                map.put(st, map.get(st) + 1);
            }else{
                map.put(st, 1);
            }
        }*/
        System.out.println(stringCountMap);
    }
}
