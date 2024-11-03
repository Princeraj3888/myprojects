package com.demo.springboot_cache.test.student;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateAverage {

    public static void main(String args[]){
        //formula for calculating average marks of student is : totalNumberOfMarksObtained / totalNumberOfSubjects

        //A: 572, B: 591, C: 350, D: 430, E: 400, F: 256, I: 500, J: 410, K: 300
        Double totalNumberOfSubjects = Double.valueOf(6);
        BigDecimal totalNumberOfSubjectsB = BigDecimal.valueOf(6);
        Double marksObtainedByA = Double.valueOf(572);
        BigDecimal marksObtainedByAB = BigDecimal.valueOf(572);
        BigDecimal marksObtainedByB = BigDecimal.valueOf(591);

        System.out.println("average marks of student A is : "+ marksObtainedByA/totalNumberOfSubjects);
        System.out.println("average marks of student A in bigdecimal is : "+ marksObtainedByAB.divide(totalNumberOfSubjectsB, 2, RoundingMode.DOWN));
        System.out.println("average marks of student B is : "+ marksObtainedByB.divide(totalNumberOfSubjectsB));

        List<BigDecimal> studentMarksObtainedList = List.of(
                BigDecimal.valueOf(350), BigDecimal.valueOf(430), BigDecimal.valueOf(430), BigDecimal.valueOf(400),
                BigDecimal.valueOf(256), BigDecimal.valueOf(500), BigDecimal.valueOf(410), BigDecimal.valueOf(300));

        System.out.println(studentMarksObtainedList);
        Map<BigDecimal, BigDecimal> averageMap = new HashMap<>();
        studentMarksObtainedList.stream().forEach(info ->
                averageMap.put(info, info.divide(totalNumberOfSubjectsB, 2, RoundingMode.DOWN)));

        System.out.println(averageMap);

        System.out.println("new map is: "+averageMap.size());

        averageMap.forEach((key, value) ->{
            System.out.println("key= "+key + " value= "+value);
        });
    }
}
