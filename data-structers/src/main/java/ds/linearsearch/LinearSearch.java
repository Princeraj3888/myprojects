package ds.linearsearch;

public class LinearSearch {
    public static void main(String[] args){
        int[] intArray = {2, 3, 4, 5, 9, 3, 1, 5, 7, 3};
        int target = 5;
        //findElementInArray(intArray, target);

        //findMultipleElementsInArray(intArray, target);
        //findMaxValueFromArray(intArray);

        int arr2d[][] = {
                {1, 5, 3, 4},
                {4, 5, 2, 3},
                {8, 1, 2, 3},
                {5, 4, 3, 4}
            };
        //findFirstOccurrenceIn2DArray(arr2d, target, false);
        //findFirstOccurrenceIn2DArray(arr2d, target, true);
        //findMultipleElementsIn2DArray(arr2d, target);
        findMaximumInSubArray(arr2d);
    }

    private static void findMaximumInSubArray(int[][] arr2d) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr2d.length; i++){
            int sum =0;
            for(int j=0; j<arr2d[i].length; j++){
                sum += arr2d[i][j];
            }
            System.out.println("sum: "+sum);
            if(max < sum){
                max = sum;
            }
        }

        System.out.println("maximum in sub array: "+ max);
    }

    private static void findMultipleElementsIn2DArray(int[][] arr2d, int target) {
        int k = 0;
        int size = 0;
        for(int i=0; i<arr2d.length; i++){
            size = size + arr2d[i].length;
        }
        int result[][] = new int[size][2];
        for(int i=0; i<arr2d.length; i++){
            boolean found = false;
            for(int j=0; j<arr2d[i].length; j++){
                if(arr2d[i][j] == target){
                    result[k][0] = i;
                    result[k][1] = j;
                    k++;
                }
            }
        }
        if(k == 0){
            System.out.println("Element not found");
        }else{
            for(int i=0; i< k; i++){
                System.out.println("Element found: "+result[i][0]+" , "+result[i][1]);
            }
        }

    }

    private static void findFirstOccurrenceIn2DArray(int[][] arr2d, int target, boolean findLast) {
        int outerIndex = -1;
        int innerIndex = -1;

        for(int i=0; i<arr2d.length; i++){
            boolean found = false;
            for(int j=0; j<arr2d[i].length; j++){
                if(arr2d[i][j] == target){
                    outerIndex = i;
                    innerIndex = j;
                    if(findLast == false) {
                        found = true;
                        break;
                    }
                }
            }
            if(found == true){
                break;
            }
        }

        if(outerIndex == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found: "+outerIndex+" , "+innerIndex);
        }
    }

    private static void findMultipleElementsInArray(int[] intArray, int target) {
        int[] answer = new int[intArray.length];
        int k = 0;
        for(int i=0; i<intArray.length; i++){
            if(intArray[i] == target){
                answer[k] = i;
                k++;
            }
        }
        if(answer.length == 0){
            System.out.println("Element not found");
        }else{
            for(int j=0; j<k; j++){
                System.out.println("Element found: "+answer[j]);
            }
        }
    }

    public static void findElementInArray(int[] intArray, int target){
        int answer = -1;
        for(int i=0; i<intArray.length; i++){
            if(intArray[i] == target){
                answer = i;
                break;
            }
        }
        if(answer == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found: "+answer);
        }
    }

    public static void findMaxValueFromArray(int[] intArray){
        //int max = intArray[0];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<intArray.length; i++){
            if(max < intArray[i]){
                max = intArray[i];
            }
        }

        System.out.println("maximum value in an array is: "+max);
    }


}
