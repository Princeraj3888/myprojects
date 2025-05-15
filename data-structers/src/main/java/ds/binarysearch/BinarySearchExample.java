package ds.binarysearch;
public class BinarySearchExample {
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 21};
        int target = 10;
        //findAnElementInArray(arr, target);

        int[] arr2 = {90, 85, 80, 75, 70, 65, 60, 55, 50};
        int target2 = 10;
        //binarySearchDesc(arr2, target2);

        binarySearchAgnostic(arr, target);
        binarySearchAgnostic(arr2, target2);
    }
    public static void findAnElementInArray(int[] arr, int target){

        int start = 0;
        int end = arr.length -1;
        int result = -1;
        while(start<=end) {
            int mid = start + (end - start) / 2;
            /*System.out.println("value of start: "+start);
            System.out.println("value of end: "+end);
            System.out.println("value of mid: "+mid);*/
            if(arr[mid] == target){
                result = mid;
                break;
            }else if(arr[mid] < target){
                start = mid + 1;
                //System.out.println("start value incremented: "+start);
            }else {
                end = mid - 1;
                //System.out.println("end value decremented: "+start);
            }
        }
        if(result == -1){
            System.out.println("element not found");
        }else{
            System.out.println("element found: "+result);
        }
    }


    public static void binarySearchDesc(int[] arr2, int target){
        int start = 0;
        int end = arr2.length-1;
        int result = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr2[mid] == target){
                result = mid;
                break;
            }else if(arr2[mid] < target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        if(result == -1){
            System.out.println("element not found: ");
        }else{
            System.out.println("element found at index: "+result);
        }
    }

    public static void binarySearchAgnostic(int arr[], int target){
        int start = arr[0];
        int end = arr[arr.length-1];

        if(start<=end){
            findAnElementInArray(arr, target);
        }else{
            binarySearchDesc(arr, target);
        }
    }
}
