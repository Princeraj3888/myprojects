package com.demo.springboot_cache.test.hackerrank;

public class MaximumOfQuadrant {

    public static void main(String[] args) {
        int[][] matrix = {
                {112, 42, 83, 119},
                {56, 125, 56, 49},
                {15, 78, 101, 43},
                {62, 98, 114, 108}
        };

        int result = maximizeUpperLeftQuadrantSum(matrix);
        System.out.println("Maximized sum of the upper-left quadrant: " + result); // Output: 414
    }

    private static int maximizeUpperLeftQuadrantSum(int[][] matrix) {

        int n = matrix.length/2;
        int maxResult=0;


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int maxValue = Math.max(
                        Math.max(matrix[i][j], matrix[i][2*n-j-1]),
                        Math.max(matrix[2*n-i-1][j], matrix[2*n-i-1][2*n-j-1])
                );
                maxResult += maxValue;
            }
        }

        return maxResult;
    }
}
