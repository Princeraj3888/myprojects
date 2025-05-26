package ds.binarysearch;

public class BinarySearchWithOccurrence {

    public static void main(String args[]){
       // int[] arr = {1, 2, 2, 3, 4, 4, 4, 5};

         int[] arr = {4, 4, 4, 8, 8, 8, 15, 16, 23, 23, 42};
        int target = 8;
        int first = binarySearch(arr, target, true);
        int last = binarySearch(arr, target, false);

        /*if(first == -1){
            System.out.println("occurrence of target is: "+0);
        }else {
            System.out.println("occurrence of target is: " + (last - first + 1));
        }*/

        /*int floor = binarySearchFloor(arr, 7);
        System.out.println("floor is: "+floor);

        int ceil = binarySearchCeil(arr, 45);
        System.out.println("ceil is: "+ceil);*/

        /*char[] letters1 = {'c','f','j'};//answer is f
        char target1 = 'c';

        char[] letters2 = {'x', 'x', 'y', 'y'};//answer is x
        char target2 = 'z';

        char[] letters3 = {'c','f','j'};//answer is c
        char target3 = 'a';

        char letter1Result = binarySearchCeil(letters1, target1);
        char letter2Result = binarySearchCeil(letters2, target2);
        char letter3Result = binarySearchCeil(letters3, target3);

        System.out.println("letter1Result: "+letter1Result);
        System.out.println("letter2Result: "+letter2Result);
        System.out.println("letter3Result: "+letter3Result);*/

        //int[] arr3 = {2, 2, 4, 5, 7, 9, 25, 56, 88, 94};
        //binarySearchToFindAbsoluteDifference(arr3, 100);

        //int[] range = findRangeInInfiniteRange(arr3, 0);

        //binarySearchInfiniteRange(arr3, 0, range[0], range[1]);

        binarySearchToFindOneInInfiniteArray();

    }

    private static int binarySearch(int arr[], int target, boolean isFirst){
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]==target){
                result = mid;
                if(isFirst){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        //if(result == -1){
            //System.out.println("element not found");
            return result;
        //}else{
            //System.out.println("element found at index: "+result);
            //return result;
        //}
    }

    private static int binarySearchFloor(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int result = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                result = arr[mid];
                break;
            }else if(arr[mid]<target){
                start = mid + 1;
                result = arr[mid];
            }else{
                end = mid - 1;
            }
        }

        return result;
    }

    private static int binarySearchCeil(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                result = arr[mid];
                break;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
                result = arr[mid];
            }
        }

        return result;
    }

    //you are given an array of characters that are sorted in non-descending order and a character target.
    //there are atleast two different characters in letters. return the smallest character in letters that is lexicographically
    //greater than target. if such element does not exist, return the first character in letters.
    private static char binarySearchCeil(char[] chars, char target){
        int start = 0;
        int end = chars.length - 1;
        char result = '$';
        while(start<=end){
            int mid = start + (end - start)/2;
            if(chars[mid]<=target){
                start = mid + 1;
            }else{
                end = mid - 1;
                result = chars[mid];
            }
        }

        return result=='$'?chars[0]:result;
    }

    private static void binarySearchToFindAbsoluteDifference(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while(start <=end){
            int mid = start + (end - start)/2;
            if(arr[mid]==target){
                result = mid;
                break;
            }else if(arr[mid]<target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        int res= 0;

        //this case is for element not found
        if(result == -1){
            if(end == -1){
                res = Math.abs(target - arr[start]);
            }else if(start == arr.length){
                res = Math.abs(target - arr[end]);
            }else{
                int ans1 = Math.abs(target - arr[start]);
                int ans2 = Math.abs(target - arr[end]);
                res = Math.min(ans1, ans2);
            }
        }
        System.out.println("minimum absolute difference is : "+ res);
    }

    private static int[] findRangeInInfiniteRange(int[] arr, int target){
        int[] range = new int[2];
        int start = 0;
        int end = 1;
        while(arr[end] < target){
            start = end;
            end = 2 * end;
        }
        range[0] = start;
        range[1] = end;
        return range;
    }

    private static void binarySearchInfiniteRange(int[] arr, int target, int start, int end){
        int result = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]==target){
              result = mid;
              break;
            }else if(arr[mid]<target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        if(result == -1){
            System.out.println("element not found");
        }else{
            System.out.println("element found at index: "+result);
        }
    }

    private static void binarySearchToFindOneInInfiniteArray(){
        int[] arr = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1};
        int[] range = findRangeInInfiniteRange(arr, 1);
        int start = range[0];
        int end = range[1];
        int target = 1;
        int result = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                result = mid;
                end = mid - 1;
            }else if(arr[mid]<target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        if(result == -1){
            System.out.println("element not found");
        }else{
            System.out.println("element found at index: "+result);
        }
    }
}