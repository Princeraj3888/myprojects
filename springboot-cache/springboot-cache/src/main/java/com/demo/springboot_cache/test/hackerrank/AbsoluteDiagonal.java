package com.demo.springboot_cache.test.hackerrank;

import java.util.Scanner;

public class AbsoluteDiagonal {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int arrLength = sc.nextInt();
        int arr[][] = new int[arrLength][arrLength];
        for(int i=0; i<arrLength; i++){
            for(int j=0; j<arrLength; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(arr.toString());
        //calculate and print the result
        int result = diagonalDifference(arr);
        System.out.println(result);

    }

    private static int diagonalDifference(int[][] arr) {
        int primaryDiagonal=0;
        int secondaryDiagonal=0;
        int result=0;
        int length = arr.length;
        for(int i =0; i< length; i++){
            primaryDiagonal += arr[i][i];
            secondaryDiagonal += arr[i][length-1-i];
        }
        result = Math.abs(primaryDiagonal - secondaryDiagonal);
        return result;
    }
}
