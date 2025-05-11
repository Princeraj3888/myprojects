package java8.practice;

import java.util.*;

public class CheckStringsAnagram {
    public static void main(String[] args){
        String[] stringList = {"abc", "tea", "eat", "ate", "cde", "madam", "adam", "flight", "racecar"};

        findAnagramFromArray(stringList);
    }

    private static void findAnagramFromArray(String[] stringList) {
        Map<String, List<String>> stringListMap = new HashMap<>();

        for(String s : stringList){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sortedString = Arrays.toString(ch);
            stringListMap.computeIfAbsent(sortedString, k->new ArrayList<>()).add(s);
        }

        System.out.println("stringListMap: "+stringListMap);
    }
}
