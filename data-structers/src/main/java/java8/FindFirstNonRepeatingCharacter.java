package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingCharacter {
    public static void main(String args[]){
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        System.out.println("=========================================");
        System.out.println(findFirstNonRepeatingCharUsingStream("leetcode"));
        System.out.println(findFirstNonRepeatingCharUsingStream("hello"));
        System.out.println(findFirstNonRepeatingCharUsingStream("aabbcc"));

    }

    public static Character findFirstNonRepeatingCharUsingStream(String givenString){
        Map<Character, Long> characterMap = givenString.chars()
                .mapToObj(ch -> (char) ch)
                .collect(LinkedHashMap::new,
                        (map, c) -> map.put(c, (map.getOrDefault(c, 0L) + 1)),
                    LinkedHashMap::putAll);
        return characterMap.entrySet().stream().filter(l -> l.getValue() == 1)
        .map(Map.Entry::getKey).findFirst().orElse(null);
    }

    public static Character firstNonRepeatingChar(String givenString){

        Map<Character, Integer> characterMap = new LinkedHashMap<>();
        char[] characterArray = givenString.toCharArray();

        for(Character ch : characterArray){
            if(characterMap.containsKey(ch)){
                characterMap.put(ch, characterMap.get(ch) + 1);
            }else{
                characterMap.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : characterMap.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return null;
    }
}
