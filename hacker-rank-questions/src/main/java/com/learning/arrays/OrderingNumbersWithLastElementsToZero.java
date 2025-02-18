package com.learning.arrays;

import java.util.Arrays;

public class OrderingNumbersWithLastElementsToZero {

    //hacker rank question is how to move all the zero elements to end
    public static void main(String args[]){

        int arr[] = {7, 8 , 0, 1, 5, 0, 7, 9, 0, 3};

        //first we will iterate over the loop and if element is not equal to zero swap the elements
        int temp = 0;
        int writeIndex = 0;
        int length = arr.length;
        for(int i=0; i<length; i++){
            //if element not equal to zero increment the write index
            if(arr[i]!=0){
                //if array index is not equal to write index
                if(arr[i]!=arr[writeIndex]){
                    temp = arr[i];
                    arr[writeIndex] = arr[i];
                    arr[i] = temp;
                }
                writeIndex ++;
            }
        }

        for(int i = writeIndex; i<length; i++){
            arr[i] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }
}
