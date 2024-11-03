package com.demo.springboot_cache.test.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBySample {

    public static void main(String args[]){
        List<Character> charArray = List.of('a', 'b', 'b', 'a', 'c', 'd', 'a', 'c', 'd', 'b');

        Map<Character, List<Character>> listMap = charArray.stream().collect(Collectors.groupingBy(Character::charValue));
        System.out.println("listMap:"+listMap);

        Map<Character, Integer> map = new HashMap<>();
        listMap.forEach((character, characters) -> {map.put(character, characters.size());});
        System.out.println("map:"+map);
    }
}
