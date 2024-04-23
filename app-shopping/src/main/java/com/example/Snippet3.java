package com.example;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
class Department {
    private Long deptId;
    private String name;

    public Department(String name) {
        this.name = name;
    }
}

@Data
class Employee {

    private Long empId;
    private String name;
    private List<Department> department;

    public Employee(String name, List<Department> department) {
        this.name = name;
        this.department = department;
    }
}

public class Snippet3 {

    //provide psuedo code to get list of Departments for a given name

    public List<Department> getDepartments(String name) {


        List<Employee> employess = Arrays.asList(
                new Employee("scott", List.of(new Department("SALES"), new Department("LEGAL"))),
                new Employee("tom", List.of(new Department("INVOICE"), new Department("LEGAL"))),
                new Employee("liam", List.of(new Department("SPORTS"), new Department("LEGAL"))));

        //provide psuedo code to get list of Departments for a given name

        List<Department> departments = employess.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .map(Employee::getDepartment)
                .findFirst()
                .orElse(List.of());
        Department dept = employess.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .flatMap(employee -> employee.getDepartment().stream())
                .filter(department -> department.getName().equalsIgnoreCase("SPORTS"))
                .findAny().orElse(null);

        return null;
    }

    public static void main(String args[]){


        Snippet3 a = new Snippet3();
        a.getDepartments("liam");
    }
}