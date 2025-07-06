package ds.array;

import java.util.Scanner;

public class ArrayExample {

    public static void main(String[] args){
        int[] arr1 = new int[5];

        int[] arr2 = {4, 7, 21, 56, 47, 12, 1, 3, 7};
        /*printArray(arr2);

        System.out.println("\n------------inserting element---------");
        insert(arr2, 3, 5);
        printArray(arr2);
        System.out.println("\n------------delete an element---------");
        delete(5, arr2);
        printArray(arr2);*/

        int[][] my2dArray = new int[3][3];

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<my2dArray.length; i++){

            for(int j=0; j<my2dArray[i].length; j++){
                System.out.println("enter "+j+" element: ");
                int ele = sc.nextInt();
                my2dArray[i][j] = ele;
            }
        }
        print2DArray(my2dArray);

        insert2dArray(my2dArray, 1, 2, 21);

        print2DArray(my2dArray);
    }

    private static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
            if(i!=arr.length-1){
                System.out.print(", ");
            }
        }
    }

    private static void insert(int[] arr2, int pos, int element){

        int length = arr2.length;

        if(pos<0 || pos> length-1){
            System.out.println("wrong position provided");
        }

        //shift the elements to the end of the array
        for(int i=length-2; i>=pos; i--){
            arr2[i+1] = arr2[i];
        }

        arr2[pos] = element;
    }

    private static void delete(int pos, int[] arr){
        for(int i = pos; i<arr.length-1; i++){
            arr[i] = arr[i+1];
        }

        arr[arr.length-1] = 0;
    }

    public static void print2DArray(int arr[][]){
        System.out.println("printing 2dArray");
        for(int i=0; i<arr.length; i++){
            System.out.println("for: "+i+" index :");
            printArray(arr[i]);
            System.out.println("");
        }
    }

    public static void insert2dArray(int arr[][], int pos1, int pos2, int ele){
        insert(arr[pos1], pos2, ele);
    }

    public static void delete2Array(int arr[][], int pos1, int pos2){
        delete(pos2, arr[pos1]);
    }
}
