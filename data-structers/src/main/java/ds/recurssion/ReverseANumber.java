package ds.recurssion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseANumber {

    public static void main(String[] args){
        //int reverseNumber = reverseNumber(543210, 0);
        reverseNumberUsingRecursion(543210);
        reverseIntegerList();
        reverseAString();
        countFrequencyOfString();
        characterFrequencyMap();
        String number = "543210";
        int index = 0;
        String res = "";
        reverseStringNumberUsingRecursion(number, index, res);
        System.out.println("response: "+res);
    }

    public static void reverseNumberUsingRecursion(int number){
        if(number == 0)
            return;
        //res = res * 10 + (number % 10);
        System.out.print(number % 10);
        reverseNumberUsingRecursion(number/10);
    }

    public static void reverseStringNumberUsingRecursion(String input, int index, String res){
        if(index == input.length()){
            return;
        }
        reverseStringNumberUsingRecursion(input, index + 1, res);
        System.out.print(res + input.charAt(index));
    }

    public static void reverseIntegerList(){
        List<Integer> integerList = List.of(12, 1, 45, 78, 23, 45, 66, 78, 12, 42);

        List<Integer> reverseList = IntStream.range(0, integerList.size())
                .mapToObj(i -> integerList.get(integerList.size() - 1 - i))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("\n reverse of integer list: "+reverseList);
    }

    public static void reverseAString(){
        String str = "newstring";
        String reverseString = IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        System.out.println("reverse of string: "+reverseString);
    }

    public static void countFrequencyOfString(){
        List<String> stringList = List.of("hi", "iam", "hi", "test", "test", "here", "there", "frequency");
        Map<String, Long> frequencyMap = stringList.stream()
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()));
        System.out.println("string frequency map: "+frequencyMap);
    }

    public static void characterFrequencyMap(){
        String str= "sentence";
        Map<String, Long> characterFreqMap = str.chars().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        System.out.println("characterFreqMap: "+characterFreqMap);
    }
}
