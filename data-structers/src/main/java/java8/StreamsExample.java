package java8;

import java8.practice.FindStudentPercentage;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args){
        //remove duplicates from list and preserve the order
        //removeDuplicatesAndPreserveOrder();
        
        //find all the numbers starting with 1
        //findAllTheNumbersStartsWithOne();

        //combine to streams
        //combineTwoStreams();

        //merge two sorted list into one with sorted order
        //combineTwoSortedList();

        //check if there is prime number from the given list of numbers
        //findPrimeNumbersInAList();
        //findPrimeNumbersTillTargetElement(100);

        //peek method in streams are used for debugging purpose
        //checkPeekMethodUsage();

        //find the string, starts with digits
        checkTheCharactersWithNumbers();

        String str = "madam";
        String str1 = "help";
        //System.out.println("is string "+str+" is palindrome: "+checkPalindromeUsingForLoop(str));
        //System.out.println("is string "+str1+" is palindrome: "+checkPalindromeUsingForLoop(str1));

        //System.out.println("given string "+str+" is palindrome: "+checkPalindromeUsingStream(str));
        //System.out.println("given string "+str1+" is palindrome: "+checkPalindromeUsingStream(str1));

        //sortDecimalsInReverseOrder();

        //find the nth smallest or nth largest number from list
        //findTheNthSmallestNumber();

        //findTheLastNumberFromList();

        //findSumOfFirstTwoNumbersFromList();

        //find the sum of unique elements from the list
        //findSumOfUniqueNumbersFromTheList();

        //find the elements which has vowels found k times in a given sentence
        //findTheVowelsSentenceInString();

        //findKIndexOfCharacterAndReplace();

        //find the first non-repeating character from a given string
        //findNonRepeatingCharacterInAString();

        //find statistics from given list of integers
        //findStatisticsFromAnIntegerList();

        //find the third-largest length element from the list of string
        //findTheHighestLengthElement();

        //count the characters in a given string
        //countTheCharacterInAString();

        //find the intersection of two list
        //findTheIntersectionOfTwoList();

        //group by employees based on the salary
        //groupByEmployeesBySalary();

        //partition a list in even and odd numbers
        //partitionListOfNumbers();

        //calculate average marks of the students
        //calculateAverageMarksOfStudents();

        //calculate average student age
        //calculateAverageStudentAge();

        //sort by multiple values
        //sortByMultipleValues();

        //count the number of words in a given string
        //countNoOfWordsInAListOfString();

        //find the longest string from the list of strings
        //findTheLongestStringFromStringList();

        //find duplicate numbers from list of integers
        //findDuplicatesFromIntegerList();

        //find strings are anagrams
        //findAnagramStrings();

        //there is a list with numbers, iterate over the list and count no of times its repetition
        //findRepeatitionOfNumberInList();


    }

    private static void reverseAnIntegerArray(){
        int[] integersArr = {1, 2, 78, 5, 2, 4, 3, 4};
        int[] reverseArray = IntStream.range(0, integersArr.length)
                .map(i -> integersArr[integersArr.length - i - 1])
                .toArray();

        System.out.println("reversedArray: "+Arrays.toString(reverseArray));

        List<Integer> integerList = List.of(7, 41, 5, 21, 3, 54, 65, 12, 42);
        List<Integer> reverseList = IntStream.rangeClosed(0, integersArr.length)
                .mapToObj(i -> integerList.get(integerList.size() - i - 1))
                .collect(Collectors.toList());

        System.out.println("reverseList: "+reverseList);
    }
    private static void reverseAString(){
        String str = "this is a string";
        System.out.println("original string: "+ str);
        String reverseString = IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - i - 1))
                .map(String::valueOf)
                .collect(Collectors.joining(""));

        System.out.println("reverse of string: "+reverseString);
    }

    private static void exampleOfReduceMethodUsage() {
        List<Integer> integerList = Arrays.asList(5, 3, 2, 9, 1, 4, 5, 8);
        int sum = integerList.stream().reduce(1, (a, b) -> a + b);
        System.out.println("sum: "+sum);
    }

    private static void findRepeatitionOfNumberInList() {
        List<Integer> integerList = Arrays.asList(12, 15, 1, 3, 5, 24, 78, 64, 23, 45, 15, 1, 3, 5, 78, 23);
        System.out.println("original list: "+integerList);
        int maxNumber = integerList.stream().max(Integer::compare).orElse(0);

        List<Integer> newList = IntStream.rangeClosed(0, maxNumber).mapToObj(n -> 0)
                .collect(Collectors.toList());

        integerList.forEach(ele -> newList.set(ele, newList.get(ele) + 1));
        System.out.println("newList: "+newList);

        /*Map<Integer, Long> map = integerList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.forEach((k, v) -> System.out.println("key: "+k+" v: "+v));*/
    }

    private static void findAnagramStrings() {
        List<String> stringList = Arrays.asList("tea", "eat", "do", "did", "listen","silent");
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String str : stringList){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedString = new String(ch);
            anagramMap.computeIfAbsent(sortedString, k -> new ArrayList()).add(str);
        };
        anagramMap.forEach((k, v) -> System.out.println("key: "+k+" value: "+v));
    }

    private static void findDuplicatesFromIntegerList() {
        List<Integer> integerList = Arrays.asList(5, 3, 2, 1, 9, 4, 8);

        Set<Integer> integerSet = new HashSet<>();
        boolean containsDuplicate = integerList.stream()
                .anyMatch(ele -> !integerSet.add(ele));
        System.out.println("list contains duplicate: "+containsDuplicate);

        /*for(int i=0; i<integerList.size(); i++){
            if(!integerSet.add(integerList.get(i))){
                System.out.println("the duplicate element is: "+integerList.get(i));
                return;
            }
        }*/

    }

    private static void findTheLongestStringFromStringList() {
        List<String> stringList = Arrays.asList("apple", "banana", "strawberry", "jack fruit", "orange", "kiwi");
        Optional<String> longestString = stringList.stream()
                .max(Comparator.comparingInt(String::length));
        longestString.ifPresent(System.out::println);
    }

    private static void countNoOfWordsInAListOfString() {
        List<String> stringList = Arrays.asList("apple", "banana", "apple", "banana", "orange", "cherry");
        Map<String, Long> countMap = stringList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        countMap.forEach((string, count) -> System.out.println(string + " : "+ count));
    }

    private static void sortByMultipleValues() {
        List<Employee> employeeList =  FindMaximumSalary.addEmployeeDetails();
        System.out.println("original employee list: "+employeeList);
        List<Employee> sortedEmployeeList = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName).reversed()).toList();
        System.out.println("sorted employee list: "+sortedEmployeeList);

    }

    private static void calculateAverageStudentAge() {
        List<String> subjectList = FindStudentPercentage.createSubjectsForAllStudents();
        List<Student> studentList = FindStudentPercentage.createStudentDetails(subjectList);

        double averageAge = studentList.stream()
                .collect(Collectors.averagingDouble(Student::getAge));
        System.out.println("average age: "+averageAge);

        double avgAge = studentList.stream()
                .mapToInt(Student::getAge)
                .average().orElse(0.0);
        System.out.println("avg age: "+avgAge);

    }

    private static void calculateAverageMarksOfStudents() {
        List<String> subjectList = FindStudentPercentage.createSubjectsForAllStudents();
        List<Student> studentList = FindStudentPercentage.createStudentDetails(subjectList);

        double averageOfStudentsMarks = studentList.stream()
                .collect(Collectors.averagingDouble(st -> {
                    return st.getMarks().stream().mapToDouble(Integer::intValue).sum();
                }));
        System.out.println(averageOfStudentsMarks);
    }

    private static void partitionListOfNumbers() {
        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitionList = integerList1.stream()
                .collect(Collectors.partitioningBy(ele -> ele % 2 == 0));
        System.out.println("even number: "+partitionList.get(true));
        System.out.println("odd number: "+partitionList.get(false));
    }

    private static void groupByEmployeesBySalary() {

        List<Employee> employeeList =  FindMaximumSalary.addEmployeeDetails();
        Map<BigDecimal, List<Employee>> groupBySalaryMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));
        groupBySalaryMap.forEach((s, e) -> System.out.println("salary: "+s+" employee list: "+e));
    }

    private static void findTheIntersectionOfTwoList() {
        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> integerList2 = Arrays.asList(4, 5, 6, 7, 8, 9);

        List<Integer> intersectionList = integerList1.stream()
                .filter(integerList2::contains)
                .toList();
        System.out.println(intersectionList);

        /*List<Integer> newIntersectionList = new ArrayList<>(integerList1);
        newIntersectionList.retainAll(integerList2);
        System.out.println(newIntersectionList);*/
    }

    private static void countTheCharacterInAString() {
        String str = "hello world";
        Map<String, Long> charCountMap = Arrays.stream(str.split(""))
                .filter(st -> !str.isBlank())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        charCountMap.forEach((character, count) -> System.out.println("character: "+character+" count: "+count));

        Map<Character, Long> characterCountMap = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        characterCountMap.forEach((character, count) -> System.out.println("char: "+character+" count: "+count));
    }

    private static void findTheHighestLengthElement() {
        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "mango", "orange", "kiwi");
        stringList.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .skip(2)
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void findStatisticsFromAnIntegerList() {
        List<Integer> integerList = Arrays.asList(5, 3, 2, 1, 9);

        IntSummaryStatistics summary = integerList.stream()
                .mapToInt(n -> n)
                .summaryStatistics();

        System.out.println("The minimum no from list: "+summary.getMin());
        System.out.println("The maximum no from list: "+summary.getMax());
        System.out.println("The average of numbers from list: "+summary.getAverage());
        System.out.println("The sum of all numbers from list: "+summary.getSum());
        System.out.println("The count of numbers from list: "+summary.getCount());
    }

    private static void findNonRepeatingCharacterInAString() {
        String str = "swiss";
        Optional<Character> nonRepeatingFirstChar = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(ele -> ele.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        nonRepeatingFirstChar.ifPresent(System.out::println);
    }

    private static void findKIndexOfCharacterAndReplace() {
        String str = "bangalore";
        int k = 3;
        String vowels = "aeiou";
        System.out.println("original string: "+str);
        String replacedString = str.chars()
                .mapToObj(ch -> (char) ch)
                .map(ch -> {
                    if(vowels.indexOf(ch)!=-1){
                        int index = (vowels.indexOf(ch) + k) % vowels.length();
                        return vowels.charAt(index);
                    }else{
                        return ch;
                    }
                })
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        System.out.println("replaced string: "+replacedString);
    }

    private static void findTheVowelsSentenceInString() {

        String str = "i have an apple and orange on the table";
        int k = 3;

        Arrays.stream(str.split(" "))
                .filter(word -> countTheVowelsInTheWord(word) >= k)
                .forEach(System.out::println);
    }

    public static long countTheVowelsInTheWord(String word){
        return word.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> "aeiouAEIOU".indexOf(ch)==-1)
                .count();
    }

    private static void findSumOfUniqueNumbersFromTheList() {
        List<Integer> integerList = Arrays.asList(12, 15, 1, 3, 5, 24, 78, 64, 23, 45, 15, 1, 3, 5, 78, 23);

        int sumOfUniqueNumbers = integerList.stream()
                .distinct()
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println("sumOfUniqueNumbers: "+sumOfUniqueNumbers);
    }

    private static void findSumOfFirstTwoNumbersFromList() {

        List<Integer> integerList = Arrays.asList(12, 15, 1, 3, 5, 24, 78, 64, 23, 45, 15);
        int sumOfFirstTwo = integerList.stream()
                .limit(2)
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println("sumOfFirstTwo: "+sumOfFirstTwo);

        Optional<Integer> multiplyOfFirstTwo = integerList.stream()
                        .limit(2)
                .reduce((a, b) -> a * b);
        multiplyOfFirstTwo.ifPresent(ele -> System.out.println("multiplication of two numbers: "+ele));
    }

    private static void findTheLastNumberFromList() {
        int[] arr = {12, 15, 1, 3, 5, 24, 78, 64, 23, 45, 15};
        Arrays.stream(arr)
                .skip(arr.length -1)
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void findTheNthSmallestNumber() {
        int[] arr = {12, 15, 1, 3, 5, 24, 78, 64, 23, 45, 15};
        int n = 3;

        Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void sortDecimalsInReverseOrder() {
        List<Double> decimalList = Arrays.asList(10.2, 14.1, 0.7, 2.3, 0.9, 10.28, 11.00, 0.21);

        decimalList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    private static void findPrimeNumbersInAList() {
        List<Integer> integerList1 = Arrays.asList(10, 12, 4, 8, 15, 1, 78, 85, 23, 17, 13, 4);

        /*integerList1.stream().filter(StreamsExample::isPrime)
                .forEach(System.out::println);*/
        List<Integer> primeNumbers = integerList1.stream()
                .filter(StreamsExample::isPrimeUsingStreams)
                .toList();
        System.out.println("primeNumbers: "+primeNumbers);
    }

    private static void findPrimeNumbersTillTargetElement(int target){
        List<Integer> primeNumbersList = IntStream.range(0, target)
                .filter(StreamsExample::isPrimeUsingStreams)
                .boxed()
                .toList();
        System.out.println("primeNumbersList: "+primeNumbersList);
    }

    private static void combineTwoSortedList() {
        List<Integer> integerList1 = Arrays.asList(10, 12, 4, 8, 15, 1);
        List<Integer> integerList2 = Arrays.asList(0, 78, 85, 23, 17, 13, 4);

        List<Integer> sortedList = Stream.concat(integerList1.stream(), integerList2.stream())
                .sorted()
                .toList();
        System.out.println("sortedList: "+sortedList);
    }

    private static void combineTwoStreams() {
        List<Integer> integerList1 = Arrays.asList(10, 12, 4, 8, 15, 1);
        List<Integer> integerList2 = Arrays.asList(0, 78, 85, 23, 17, 13);

        List<Integer> combinedStreamList = Stream.concat(integerList1.stream(), integerList2.stream()).toList();
        combinedStreamList.forEach(data -> System.out.print(data+", "));
    }

    private static void findAllTheNumbersStartsWithOne() {
        List<Integer> integerList = Arrays.asList(10, 12, 4, 8, 15, 1, 0, 78, 85, 23, 17, 13);
        System.out.println("original list: "+integerList);

        List<Integer> numberListStartsWithOne = integerList.stream()
                .filter(num -> String.valueOf(num).startsWith("1"))
                .toList();
        System.out.println("numbers starts with 1: "+numberListStartsWithOne);
    }

    private static void removeDuplicatesAndPreserveOrder() {
        List<String> stringList = new ArrayList<>();
        stringList.add("one");stringList.add("two");stringList.add("one");stringList.add("three");
        stringList.add("one");stringList.add("two");stringList.add("four");
        System.out.println("original string list: "+stringList);

        List<String> uniqueList = stringList.stream().distinct().collect(Collectors.toCollection(ArrayList::new));

        System.out.println("uniqueList: "+uniqueList);
    }

    public static boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeUsingStreams(int num){
        if(num <= 1){
            return false;
        }

        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                .noneMatch(i -> num % i == 0);
    }

    public static void checkPeekMethodUsage(){
        List<String> stringList = Arrays.asList("apple", "banana", "avocado", "blue berry", "orange");

        stringList.stream()
                .peek(word -> System.out.println("original list: "+word))
                .filter(word -> word.startsWith("a"))
                .peek(word -> System.out.println("after filter: "+word))
                .map(String::toUpperCase)
                .peek(word -> System.out.println("upper case of word: "+word))
                .toList();

        String joinedString = stringList.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(joinedString);
    }

    public static void checkTheCharactersWithNumbers(){
        List<String> stringList = Arrays.asList("1apple", "banana", "7avocado", "blue berry", "2orange");

        stringList.stream().filter(s -> Character.isDigit(s.charAt(0)))
                .forEach(System.out::println);
    }

    public static boolean checkPalindromeUsingForLoop(String str){
        int stringLength = str.length();
        for(int i=0; i < stringLength/2; i++){
            if(str.charAt(i)!=str.charAt(stringLength - 1 -i)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkPalindromeUsingStream(String str){
        return IntStream.range(0, str.length()/2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length()-1-i));
    }
}
