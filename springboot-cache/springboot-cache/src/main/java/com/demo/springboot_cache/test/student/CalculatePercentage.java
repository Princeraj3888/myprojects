package com.demo.springboot_cache.test.student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatePercentage {

public static void main(String args[]){

    //formula to calculate percentage of student is totalNumberOfMarks divide by totalNumberOfMarksObtained multiply by 100

    BigDecimal totalNoOfMarks = BigDecimal.valueOf(600);
    BigDecimal studentAMarks = BigDecimal.valueOf(500);
    BigDecimal studentBMarks = BigDecimal.valueOf(384);
    BigDecimal percentageOfStudentA = studentAMarks.divide(totalNoOfMarks, 2, RoundingMode.DOWN)
            .multiply(BigDecimal.valueOf(100));
    BigDecimal percentageOfStudentB = studentBMarks.divide(totalNoOfMarks, 2, RoundingMode.DOWN)
            .multiply(BigDecimal.valueOf(100));

    System.out.println("percentageOfStudent: "+percentageOfStudentA);
    System.out.println("percentageOfStudent: "+percentageOfStudentB);

}
}
