package java8;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseAString {

    public static void main(String args[]){

        String str = "this is my string";

        System.out.println("original string: "+str);

        String reverseString = IntStream.range(0, str.length()).mapToObj(c -> str.charAt(str.length() -1 - c))
                .map(String::valueOf).collect(Collectors.joining());

        System.out.println("reverse String: "+reverseString);

        findNonRepeatingCharacter(str);
    }

    public static void findNonRepeatingCharacter(String str){
        str = "Rajkumar";
        Map<Character, Long> charMap = str.toLowerCase(Locale.ROOT).chars()
                .mapToObj(c -> (char) c)
                .filter(character -> character!=null && character!=' ')
                .collect(LinkedHashMap::new,
                        (map, c) -> map.put(c, map.getOrDefault(c, 0L) +1),
                LinkedHashMap::putAll);

        System.out.println("charMap: "+charMap);

        char nonRepeatingCharacter = charMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse('\0');

        System.out.println("nonRepeatingCharacter: "+nonRepeatingCharacter);
    }
}
