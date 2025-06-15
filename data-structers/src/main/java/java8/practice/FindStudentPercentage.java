package java8.practice;

import java8.Student;

import java.util.*;

public class FindStudentPercentage {

    //private static List<String> subjects;

    public static void main(String[] args){
        //find percentage of students
        List<String> subjects = createSubjectsForAllStudents();
        List<Student> students = createStudentDetails(subjects);
        findPercentageOfStudent(students);
        calculateAverageOfStudent(students);
    }

    private static void calculateAverageOfStudent(List<Student> students) {
        // average of a student is calculated as total number of marks obtained by total number of subjects
        Map<String, Double> averageMap = new HashMap<>();
        for(Student student : students){
            OptionalDouble average = student.getMarks().stream().mapToInt(Integer::intValue).average();
            if(average.isPresent()){
                averageMap.put(student.getName(), average.getAsDouble());
            }
        }
        System.out.println("averageMap: "+averageMap);
    }

    private static void findPercentageOfStudent(List<Student> students) {
        //total number of marks obtained / total number of marks
        /*Map<String, Double> percentageMap = students.stream().map( student -> {
            Map<String, Double> percentM = new HashMap<>();
            int totalMarks = student.getMarks().stream().forEach(Integer::intValue);
        })*/
        Map<String, Double> percentageMap = new HashMap<>();
        for(Student student : students){
            double totalMarksObtained = student.getMarks().stream().mapToInt(Integer::valueOf).sum();
            System.out.println("student total marks: "+totalMarksObtained);
            double totalNoOfMarks = student.getSubjects().size() * 100;
            System.out.println("total no of marks: "+totalNoOfMarks);
            double percentage = (totalMarksObtained / totalNoOfMarks) * 100;
            System.out.println("percentage: "+percentage);
            percentageMap.put(student.getName(), percentage);
        }

        System.out.println("percentageMap: "+ percentageMap);

    }

    public static List<String> createSubjectsForAllStudents() {
        List<String> subjects = new ArrayList<>();
        subjects.add("maths");
        subjects.add("physics");
        subjects.add("chemistry");
        subjects.add("social");
        subjects.add("hindi");
        subjects.add("english");

        return subjects;
    }

    public static List<Student> createStudentDetails(List<String> subjects) {
        List<Student> studentList = new ArrayList<>();

        Student s1 = new Student();
        s1.setName("Rudra");
        List<Integer> marks1 = new ArrayList<>();
        marks1.add(100);
        marks1.add(95);
        marks1.add(95);
        marks1.add(90);
        marks1.add(85);
        marks1.add(100);
        s1.setMarks(marks1);
        s1.setSubjects(subjects);
        s1.setAge(15);
        studentList.add(s1);

        Student s2 = new Student();
        s2.setName("Barsha Rani");
        List<Integer> marks2 = new ArrayList<>();
        marks2.add(90);
        marks2.add(95);
        marks2.add(95);
        marks2.add(80);
        marks2.add(75);
        marks2.add(100);
        s2.setMarks(marks2);
        s2.setSubjects(subjects);
        s2.setAge(20);
        studentList.add(s2);

        Student s3 = new Student();
        s3.setName("Raj");
        List<Integer> marks3 = new ArrayList<>();
        marks3.add(85);
        marks3.add(95);
        marks3.add(90);
        marks3.add(85);
        marks3.add(85);
        marks3.add(90);
        s3.setMarks(marks3);
        s3.setSubjects(subjects);
        s3.setAge(25);
        studentList.add(s3);

        return studentList;

    }
}
