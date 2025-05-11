package java8.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindTwoSumInArray {
    public static void main(String[] args){
        int[] integerArray = {2, 5, 8, 3, 7, 3, 4};
        int target = 9;

        System.out.println("the two elements sums to target are: "+ Arrays.toString(findTwoSumInArray(integerArray, target)));
        findMaximumLengthFromStringList();

        reverseAString();
        reverseAIntegerArray();
        longestPrefix();
    }

    public static int[] findTwoSumInArray(int[] integerArray, int target){
        Map<Integer, Integer> complimentMap = new HashMap<>();
        for(int i=0; i< integerArray.length; i++){
            int complement = target - integerArray[i];
            if(complimentMap.containsKey(complement)){
                return new int[]{complimentMap.get(complement), i};
            }
            complimentMap.put(integerArray[i], i);
        }
        return new int[]{};
    }

    //complement = 9-2 = 7 -> map = (2, 0)
    //complement = 9-5 = 4 -> map = (2, 0) (5, 1)
    //complement = 9-8 = 1 -> map = (2, 0) (5, 1) (8, 2)
    //complement = 9-3 = 6 -> map = (2, 0) (5, 1) (8, 2) (3, 3)
    //complement = 9-7 = 2 -> map = (2, 0) (5, 1) (8, 2) (3, 3) -> ans: 0, 4

    public static void findMaximumLengthFromStringList(){
        List<String> stringList = List.of("testing", "max", "length", "from", "list", "of", "strings");

        Optional<String> maxLengthInString = stringList.stream().max(Comparator.comparing(String::length));
        System.out.println("maxLengthInString: "+maxLengthInString.get().length());
    }

    public static void reverseAString(){
        String str = "mynameisraj";
        String reverseString = IntStream.range(0, str.length()).mapToObj(i -> str.charAt(str.length() -1 -i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("reverse of a string: "+reverseString);
    }

    public static void reverseAIntegerArray(){
        List<Integer> integerList = List.of(4, 5, 8, 25, 35, 64, 21);

        List<Integer> reverseIntegerList = IntStream
                .rangeClosed(1, integerList.size())
                .mapToObj(i -> integerList.get(integerList.size() -i))
                .toList();
        System.out.println("reverse integer list: "+reverseIntegerList);
    }

    public static void longestPrefix(){
        List<String> stringList = List.of("flow", "fly", "flower", "flowing");

        String prefix = stringList.stream().min(Comparator.comparing(String::length)).orElse("");
        for(String s : stringList){
            while(!s.startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()){
                    break;
                }
            }
        }
        System.out.println("longest prefix: "+prefix);
    }
}
