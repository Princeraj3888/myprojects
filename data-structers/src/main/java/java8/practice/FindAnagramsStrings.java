package java8.practice;

import java.util.*;

public class FindAnagramsStrings {

    public static void main(String[] args){
        List<String> stringList = new ArrayList<>();
        stringList.add("ate");stringList.add("eat");stringList.add("tea");stringList.add("slient");stringList.add("listen");
        stringList.add("try");stringList.add("hard");

        Map<String, List<String>> anagramMap = new HashMap<>();
        for(String s : stringList){
         char[] c = s.toCharArray();
         Arrays.sort(c);
         String sortedString = new String(c);
         anagramMap.computeIfAbsent(sortedString, k->new ArrayList<>()).add(s);
        }

        System.out.println("Anagram map: "+anagramMap);

    }
}
