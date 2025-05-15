package ds.leetcode.maxsumsubarray;

public class FindMaxSumSubArray {

    public static void main(String[] args){
        int[] intArray = {100, 200, 300, 20, 50, 100, 70, 300}; // 600, 520, 370, 170, 220, 470
        int k = 3;

        int maxSum = findMaxSumOfSubArray(intArray, k);
        System.out.println("maxSum: "+maxSum);
    }

    private static int findMaxSumOfSubArray(int[] intArray, int k) {
        int maxSum = 0;
        int sum = 0;
        int size = intArray.length;
        int index = 0;
        while(index < size && index < k ){
            sum += intArray[index];
            index++;
        }
        System.out.println("sum: "+sum);
        maxSum = sum;
        for(int i=1; i < size - k + 1; i++ ){
            int prevElement = intArray[i -1];
            System.out.println("previousElement: "+prevElement);
            int nextElement = intArray[i + k - 1];
            System.out.println("nextElement: "+nextElement);

            sum = sum - prevElement + nextElement;
            System.out.println("sum: "+sum);
            maxSum = Math.max(maxSum, sum);
            System.out.println("maxSum: "+maxSum);
        }

        return maxSum;
    }
}
