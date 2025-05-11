package ds.algorithm;

import java.util.List;

public class KadanesAlogrithm {

    public static void main(String[] args){
        List<Integer> integerList = List.of(12, 45, 78, 42, 123, 456, 646, 432, 21);

        Integer currentMaxSum = 0;
        Integer maxSum = Integer.MIN_VALUE;
        for(Integer num : integerList){
            currentMaxSum += num;//177
            maxSum = Math.max(maxSum, currentMaxSum);//177
        }

        System.out.println("currentMaxSum: "+currentMaxSum+" later max sum: "+maxSum);
    }
}
