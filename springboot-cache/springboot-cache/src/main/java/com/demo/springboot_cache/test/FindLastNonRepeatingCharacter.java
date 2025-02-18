package com.demo.springboot_cache.test;

import java.util.HashMap;
import java.util.Map;

public class FindLastNonRepeatingCharacter {

    public static void main(String args[]){
        String str = "rajkumar";


        Character c = findLastNonRepeatingCharacters(str);

        System.out.println(c);
    }

    private static Character findLastNonRepeatingCharacters(String str) {

        Map<Character, Integer> map = new HashMap<>();

        char ch[] = str.toCharArray();
        for(Character character : ch){
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        System.out.println(map);
        for(int i= ch.length-1; i>=0; i--){
           if(map.get(str.charAt(i)) ==1){
               return str.charAt(i);
           }
        }
        return null;
    }
}
