package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseAnArray {

    public static void main(String[] args){

        int[] array = {1, 8 , 2 , 3, 4, 8, 7, 5, 77, 97};
        System.out.println("length of array is: "+array.length);
        reverseAnArray(array);
    }

    private static void reverseAnArray(int[] array) {

        List<Integer> reverseArray = IntStream.range(0, array.length)
                .mapToObj(i -> array[array.length-1 - i])
                .toList();
        int[] reverseA = IntStream.range(0, array.length).map(i -> array[array.length-1 -i]).toArray();
        System.out.println("reverse of array: "+ Arrays.toString(reverseA));
    }
}
