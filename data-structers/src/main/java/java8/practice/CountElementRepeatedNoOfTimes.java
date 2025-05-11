package java8.practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountElementRepeatedNoOfTimes {

    public static void main(String[] args){
        List<Integer> integerList =  List.of(21, 1, 2, 5, 0, 2, 8, 7, 9, 4,4 ,5, 3, 4, 9, 23, 45);

        System.out.println("integerList size: "+integerList.size());
        int maxValue = integerList.stream().max(Integer::compare).orElse(0);
        System.out.println("maxValue: "+maxValue);

        List<Integer> newIntegerList = IntStream.range(0, maxValue+1).mapToObj(n -> 0).collect(Collectors.toList());
        System.out.println("new integer list: "+newIntegerList);

        //List<Integer> finalList = new ArrayList<>();
        for(Integer i : integerList){
            newIntegerList.set(i, (newIntegerList.get(i)) + 1);
        }
        System.out.println("final list: "+newIntegerList);
    }
}
