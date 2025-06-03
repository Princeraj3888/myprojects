package practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Client {

    public static void main(String[] args){
        //findAnagramCharacters();
        //countArrayElementsInArray();
        //findTwoSum();
        //reverseAnIntegerList();
        //reverseAString();
        //reverseOnlyCharacters();
        /*String str = "madam";
        String str1 = "hello";
        System.out.println("is string str: "+str+" palindrome: "+checkStringIsPalindrome(str));
        System.out.println("is string str: "+str1+" palindrome: "+checkStringIsPalindrome(str1));*/

        //countNumberOfStringOccurrence();
        countNumber();
    }

    public static void countNumber(){
        String str = "i am practicing java";
        char[] chars = str.toCharArray();
        /*List<Character> list = new ArrayList<>();
        for(char ch : chars){
            list.add(ch);
        }*/
        Map<Character, Long> map = str.chars().mapToObj(ch -> (char)ch)
                .filter(character -> !character.toString().trim().isEmpty())
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        System.out.println(map);
    }

    public static void findAnagramCharacters(){
        String[] strList = {"ate", "eat", "acd", "bed", "debt"};
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strList){
            char[] chr = str.toCharArray();
            Arrays.sort(chr);
            String sortedString = new String(chr);
            map.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(str);
        }

        System.out.println("anagram strings are: "+map.values());
    }

    public static void countArrayElementsInArray(){
        List<Integer> integerList = List.of(1, 0, 8, 7, 8, 2, 3, 8, 5, 3, 1, 11, 8, 47, 32);
        int maxNumber = integerList.stream().max(Integer::compare).get();
        System.out.println("maxNumber in array list is: "+maxNumber);

        List<Integer> numberList = IntStream.range(0, maxNumber + 1).mapToObj(i -> 0).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("numberList: "+numberList);
        for(Integer i : integerList){
            numberList.set(i, numberList.get(i) + 1);
        }

        System.out.println("number list count: "+numberList);
    }

    public static void findTwoSum(){
        List<Integer> integerList = List.of(2, 3, 7, 2, 9, 4, 2, 5, 3);
        int target = 6;

        Map<Integer, Integer> map = new HashMap<>();
        for(int index=0; index<=integerList.size(); index++){
            int compliment = target - integerList.get(index); // 2, 3, 7, 2, 9,
            if(map.containsKey(compliment)){
                System.out.println("element found which sums with index: "+map.get(compliment)+" index: "+index);
                return;
            }
            map.put(integerList.get(index), index);
        }
        System.out.println("map: "+map);
    }

    public static void reverseAnIntegerList(){
        List<Integer> integerList = List.of(2, 3, 7, 2, 9, 4, 2, 5, 3);
        System.out.println("original list: "+integerList);

        List<Integer> reverseIntList = IntStream.range(0, integerList.size())
                .mapToObj(num -> integerList.get(integerList.size() - 1 - num)).toList();

        System.out.println("reversed integer list: "+reverseIntList);
    }

    public static void reverseAString(){
        String originalString = "this is my string";
        System.out.println("original string: "+originalString);

        String reverseString = IntStream.range(0, originalString.length())
                .mapToObj(ch -> originalString.charAt(originalString.length() - 1 - ch))
                .map(String::valueOf)
                .collect(Collectors.joining(""));

        System.out.println("reversed string list: "+reverseString);
    }

    public static void reverseOnlyCharacters(){
        String str = "123456firstcharacter7891011anothercharacter";

        char[] chArray = str.toCharArray();
        StringBuilder charBuilder = new StringBuilder();
        StringBuilder numberBuilder = new StringBuilder();
        for(Character ch : chArray){
            if(!Character.isDigit(ch)){
                charBuilder.append(ch);
            }else if(charBuilder.length()>2){
                numberBuilder.append(charBuilder.reverse());
                charBuilder.delete(0, charBuilder.length());
                numberBuilder.append(ch);
            }else{
                numberBuilder.append(ch);
            }
        }
        if(charBuilder.length()>0){
            numberBuilder.append(charBuilder.reverse());
            charBuilder.delete(0, charBuilder.length());
        }

        System.out.println("reverse of only characters: "+numberBuilder);
    }

    public static boolean checkStringIsPalindrome(String str2){
        int start = 0;
        int end = str2.toCharArray().length - 1;
        while(start <= end){
            if(str2.charAt(start)!=str2.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }

    public static void countNumberOfStringOccurrence(){
        List<String> stringList = List.of("Pen", "Pencil", "Book", "Note Book", "Pen", "Pencil");

        Map<String, Long> sCountMap = stringList.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        Map<Character, Integer> charMap = new HashMap<>();
       for(char ch : stringList.get(0).toCharArray()){
           charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
       }

        System.out.println("sCountMap: "+sCountMap);

        System.out.println("characterMap: "+charMap);
    }
}
