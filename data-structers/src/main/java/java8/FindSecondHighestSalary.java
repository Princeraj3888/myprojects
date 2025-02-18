package java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindSecondHighestSalary {

    public static void main(String args[]){
        List<Employee> employees = Arrays.asList(
                new Employee("Arun", BigDecimal.valueOf(2000)),
                new Employee("Varun", BigDecimal.valueOf(3000)),
                new Employee("Ajay", BigDecimal.valueOf(4000)),
                new Employee("Vijay", BigDecimal.valueOf(2000)),
                new Employee("Raja", BigDecimal.valueOf(3000)),
                new Employee("Sarath", BigDecimal.valueOf(5000)),
                new Employee("Vishnu", BigDecimal.valueOf(4000)),
                new Employee("Raja", BigDecimal.valueOf(6000)),
                new Employee("Srinu", BigDecimal.valueOf(5000)),
                new Employee("Srinu", BigDecimal.valueOf(4000)),
                new Employee("Arjun", BigDecimal.valueOf(1000)),
                new Employee("Sarath", BigDecimal.valueOf(7000)),
                new Employee("Raja", BigDecimal.valueOf(9000))
        );

        List<BigDecimal> distinctEmployees = employees.stream().map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("distinct employees list: "+distinctEmployees);
    }
}
