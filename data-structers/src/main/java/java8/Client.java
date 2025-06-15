package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Client {

    public static void main(String[] args){
        //reverseAnIntegerList();
        int numb = 543210;
        int res = 0;
        //System.out.println("given number is: "+numb+" reverse of a number is: ");
        //reverseANumberUsingRecursion(numb, res);
        //System.out.println("");
        //System.out.println("reverse of number: "+res);
        //reverseAStringUsingStreams();
        //printPrimeNumbers();
        //frequencyCount();
        String str = "sentences";
        System.out.println("original string: "+str);
        //reverseStringUsingRecursion(str, 0, "");
        //defaultMethodInInterfaceDemo();
        //findMaxSumOfGivenTargetElements();
        /*int result = binarySearch();
        if(result == -1){
            System.out.println("element not found");
        }else{
            System.out.println("element found at index: "+result);
        }*/

        System.out.println("string 'madam' a palindrome ?: "+checkGivenStringIsPalindrome("madam"));
        System.out.println("string 'hello' a palindrome ?: "+checkGivenStringIsPalindrome("hello"));

        //checkConcurrentModification();
    }

    public static void reverseAnIntegerList(){
        List<Integer> integerList = List.of(4, 7, 12, 23, 45, 75, 84, 32, 12, 41);
        System.out.println("original integer list: "+integerList);

        List<Integer> reverseIntegerList = IntStream.range(0, integerList.size())
                        .mapToObj(i -> integerList.get(integerList.size() - 1 -i))
                                .toList();

        System.out.println("reverse of an integer list: "+reverseIntegerList);
    }

    public static void reverseANumberUsingRecursion(int num, int res){
        if(num==0){
            //System.out.print(num);
            return;
        }
        //res = res * 10 + num % 10;
        System.out.print(num % 10);
        reverseANumberUsingRecursion(num / 10, res);
    }

    public static void reverseAStringUsingStreams(){
        String str1 = "this is my string";
        System.out.println("original string: "+str1);
        String reverseString = IntStream.range(0, str1.length())
                        .mapToObj(i -> str1.charAt(str1.length()-1-i))
                                .map(String::valueOf)
                                        .collect(Collectors.joining(""));

        System.out.println("reverse of string: "+reverseString);
    }

    public static void printPrimeNumbers(){
        int target = 100;
        for(int i=2; i<=target; i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }
    public static boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for(int i =2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void frequencyCount(){
        List<String> stringList = List.of("hi", "hello", "hi", "good", "fine", "cheers");
        Map<String, Long> stringFrequencyMap = stringList.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println("stringFrequencyMap: "+stringFrequencyMap);

        String str = "reverse this string";
        Map<String, Long> characterFrequencyMap = str.chars()
                .mapToObj(Character::toString)
                .filter(s -> !s.equals(" "))
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println("character frequency map: "+characterFrequencyMap);
    }

    public static void reverseStringUsingRecursion(String input, int index, String res){
        if(index == input.length()){
            return;
        }
        reverseStringUsingRecursion(input, index + 1, res);
        System.out.print(res + input.charAt(index));
    }

    public static void defaultMethodInInterfaceDemo(){
        List<String> stringList = Arrays.asList("serialization", "deserialization", "volatile", "transient", "join", "wait", "concurrency");
        stringList.sort(Comparator.naturalOrder());
        System.out.println("strings in natural sort order: "+stringList);


        //static method in list interface
        stringList.sort(Comparator.comparing(String::length));
        System.out.println("string sort after comparing: "+stringList);
    }

    public static void findMaxSumOfGivenTargetElements(){
        int arr[] = {12, 45, 78, 12, 35, 38, 89, 45, 21, 45, 47};//135, 135, 125, 85, 162, 172, 145, 111, 113
        int k = 3;

        int maxSum = 0;
        int sum = 0;
        int index = 0;
        int size = arr.length;
        while(index < size && index < k){
            sum += arr[index];
            index++;
        }

        maxSum = sum;
        for(int i=1; i<size - k + 1; i++){
            int prevElement = arr[i - 1];
            int nextElement = arr[i + k - 1];
            sum = sum - prevElement + nextElement;
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println("max sum of "+k+" elements in array is: "+maxSum);

    }

    public static int binarySearch(){
        int[] arr = {12, 12, 21, 35, 38, 45, 45, 45, 47, 78, 89};
        int target = 78;

        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                result = mid;
                return result;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return result;
    }

    public static boolean checkGivenStringIsPalindrome(String str){

        int start = 0;
        int end = str.length() - 1;
        while(start <= end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }

    public static void checkConcurrentModification(){
        List<String> stringList = new ArrayList<>();
        stringList.add("a"); stringList.add("b"); stringList.add("c"); stringList.add("d"); stringList.add("e");

        /*for(String s : stringList){
            stringList.remove(s);
        }*/
        Iterator<String> listIterator = stringList.iterator();
        while(listIterator.hasNext()){
            String element = listIterator.next();
            if(element.equals("c")){
                listIterator.remove();
            }
        }
        System.out.println("stringList: "+stringList);

        String s = null;
        /*switch (s) {
            case null:
                System.out.println("null switch case");
            default:
                System.out.println("default switch case ");
        }*/
    }
}
