package java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FindMaximumSalary {

    public List<Employee> addEmployeeDetails(){
        //Arun-2000 Varun-3000 Ajay-4000 Vijay-2000 Raja-3000 Sarath-5000 Vishnu-4000 Raja-6000 Srinu-5000 Srinu-4000, Arjun-1000, Sarath-7000, Raja-9000
        Employee emp = new Employee("Arun", BigDecimal.valueOf(2000));
        Employee emp1 = new Employee("Varun", BigDecimal.valueOf(3000));
        Employee emp2 = new Employee("Vijay", BigDecimal.valueOf(2000));
        Employee emp3 = new Employee("Raja", BigDecimal.valueOf(3000));
        Employee emp4 = new Employee("Sarath", BigDecimal.valueOf(5000));
        Employee emp5 = new Employee("Vishnu", BigDecimal.valueOf(4000));
        Employee emp6 = new Employee("Raja", BigDecimal.valueOf(6000));
        Employee emp7 = new Employee("Srinu", BigDecimal.valueOf(4000));
        Employee emp8 = new Employee("Arjun", BigDecimal.valueOf(1000));
        Employee emp9 = new Employee("Sarath", BigDecimal.valueOf(7000));
        Employee emp10 = new Employee("Raja", BigDecimal.valueOf(9000));

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp); employeeList.add(emp1);employeeList.add(emp3); employeeList.add(emp4);employeeList.add(emp5); employeeList.add(emp6);
        employeeList.add(emp7); employeeList.add(emp8);employeeList.add(emp9); employeeList.add(emp10);

        System.out.println(employeeList);
        return employeeList;
    }
}
