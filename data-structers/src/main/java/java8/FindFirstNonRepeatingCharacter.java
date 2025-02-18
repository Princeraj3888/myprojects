package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatingCharacter {
    public static void main(String args[]){
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

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
