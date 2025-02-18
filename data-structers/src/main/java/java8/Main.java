package java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String args[]){

        FindMaximumSalary findMaximumSalary = new FindMaximumSalary();
        List<Employee> employeeList = findMaximumSalary.addEmployeeDetails();

        Map<String, List<Employee>> empMap = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getName));
        // this operation is to group elements by employee name
        //System.out.println(empMap);

        Optional<Employee> distinctList = employeeList.stream().distinct()
                .max(Comparator.comparing(employee -> employee.getSalary()));
        System.out.println("distinctList: "+distinctList);

        //another way of getting max salary of an employee
        Map<String, Optional<Employee>> maxSalaryMap = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getName,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        System.out.println("maxSalaryMap: "+maxSalaryMap);
    }
}
