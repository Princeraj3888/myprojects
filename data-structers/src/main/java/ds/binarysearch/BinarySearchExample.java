package ds.binarysearch;
public class BinarySearchExample {
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 21};
        int target = 13;
        findAnElementInArray(arr, target);
    }
    public static void findAnElementInArray(int[] arr, int target){

        int start = 0;
        int end = arr.length -1;
        int result = -1;
        while(start<=end) {
            int mid = start + (end - start) / 2;
            System.out.println("value of start: "+start);
            System.out.println("value of end: "+end);
            System.out.println("value of mid: "+mid);
            if(arr[mid] == target){
                result = mid;
                break;
            }else if(arr[mid] < target){
                start = mid + 1;
                System.out.println("start value incremented: "+start);
            }else {
                end = mid - 1;
                System.out.println("end value decremented: "+start);
            }
        }
        if(result == -1){
            System.out.println("element not found");
        }else{
            System.out.println("element found: "+result);
        }
    }
}
