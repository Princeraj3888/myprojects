package ds.recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseANumber {

    public static void main(String[] args){
        //int reverseNumber = reverseNumber(543210, 0);
        //reverseNumberUsingRecursion(543210);
        //reverseIntegerList();
        //reverseAString();
        //countFrequencyOfString();
        //characterFrequencyMap();
        String number = "543210";
        int index = 0;
        String res = "";
        //reverseStringNumberUsingRecursion(number, index, res);
        //System.out.println("response: "+res);

        //vowelsReplacement("bangalore", 3);

        reverseCharArrayUsingRecursion();
    }

    public static void reverseNumberUsingRecursion(int number){
       if(number == 0){
           return;
       }
       //res = res * 10 + number % 10;
       System.out.print(number % 10);
       reverseNumberUsingRecursion(number / 10);
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

        System.out.println("original list: "+integerList);
        List<Integer> reverseList = IntStream.range(0, integerList.size())
                        .mapToObj(i -> integerList.get(integerList.size() - 1 -i))
                                .toList();
        System.out.println("\n reverse of integer list: "+reverseList);
    }

    public static void reverseAString(){
        String str = "newstring";
        System.out.println("original string: "+str);
        String reverseString = IntStream.range(0, str.length())
                        .mapToObj(i -> str.charAt(str.length() - 1 - i))
                        .map(String::valueOf)
                                .collect(Collectors.joining(""));
        System.out.println("reverse of string: "+reverseString);
    }

    public static void countFrequencyOfString(){
        List<String> stringList = List.of("hi", "iam", "hi", "test", "test", "here", "there", "frequency");
        System.out.println("string list: "+stringList);

        Map<String, Long> frequencyMap = stringList.stream()
                        .collect(Collectors.groupingBy(st -> st, Collectors.counting()));
        System.out.println("string frequency map: "+frequencyMap);
    }

    public static void characterFrequencyMap(){
        String str= "sentence";
        Map<String, Long> characterFreqMap = str.chars().mapToObj(Character::toString)
                        .collect(Collectors.groupingBy(st -> st, Collectors.counting()));

        System.out.println("characterFreqMap: "+characterFreqMap);
    }

    public static void vowelsReplacement(String str, int k){
        String vowels = "aeiou";
        StringBuffer sbf = new StringBuffer();

        for(int i=0; i<str.length(); i++){
            if(vowels.indexOf(str.charAt(i)) != -1){
                int i1 = vowels.indexOf(str.charAt(i));
                int index = (i1 + k) % k;
                sbf.append(vowels.charAt(index));
                System.out.println("if sbf: "+sbf+" index: "+index);
            }else {
                sbf.append(str.charAt(i));
                System.out.println("else sbf: "+sbf);
            }
        }

        System.out.println("sbf : "+sbf.toString());
    }

    public static void reverseCharArrayUsingRecursion(){
        char[] ch = {'h', 'e', 'l', 'l', 'o'};
        int length = ch.length;
        int index = 0;

        recursionCharArray(ch, length, index);
        System.out.println("ch: "+ Arrays.toString(ch));

    }

    private static void recursionCharArray(char[] ch, int length, int index) {
        if(index == length / 2){
            return;
        }
        recursionCharArray(ch, length, index + 1);//index = 0, 1, 2 -> length = 4
        swapElements(ch, length - index - 1, index);
    }

    private static void swapElements(char[] ch, int length, int index) {
        char temp = ch[length];
        ch[length] = ch[index];
        ch[index] = temp;
    }
}
