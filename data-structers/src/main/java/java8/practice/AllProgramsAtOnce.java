package java8.practice;

import java.util.Map;
import java.util.stream.Collectors;

public class AllProgramsAtOnce {

    public static void main(String[] args){
        String str = new String("dkfjalkjdflajl");

        Map<Character, Long> charMap = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));

        System.out.println("charMap: "+charMap);
    }
}
