package java8.practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseAnIntegerList {

    public static void main(String[] args){
        List<Integer> integerList = List.of(2, 8, 9, 3, 7, 2, 8);
        System.out.println("original list: "+integerList);
        reverseAnIntegerList(integerList);
    }

    private static void reverseAnIntegerList(List<Integer> integerList) {
        List<Integer> reverseIntList = IntStream.range(0, integerList.size())
                .mapToObj(i -> integerList.get(integerList.size()- i - 1))
                .toList();

        System.out.println("reverseIntList: "+reverseIntList);
    }
}
