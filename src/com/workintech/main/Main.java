package com.workintech.main;

import com.workintech.model.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        LinkedList<Employee> employeeList = new LinkedList<Employee>();
        employeeList.add(new Employee(1, "John", "Doe"));
        employeeList.add(new Employee(2, "Jane", "Smith"));
        employeeList.add(new Employee(3, "Alice", "Johnson"));
        employeeList.add(new Employee(1, "John", "Doe"));  // Duplicate
        employeeList.add(new Employee(4, "Michael", "Brown"));
        employeeList.add(new Employee(2, "Jane", "Smith"));  // Duplicate


        LinkedList<Employee> duplicatesList = new LinkedList<>(); //Bu liste, benzersiz olmayan çalışanları tutmak için kullanılacaktır.
        Map<Integer, Employee> uniqueEmployeeMap = new HashMap<>(); // Bu harita yapısı, çalışanların id değerine göre
        // benzersiz olup olmadığını kontrol etmek için kullanılacaktır.


        Iterator<Employee> iterator = employeeList.iterator(); //employeeList içinde gezinmek için bir iterator oluşturulur.

        while (iterator.hasNext()) {  //Liste üzerinde dolaşarak her bir elemanı kontrol eden bir döngü başlatılır.

            Employee employee = iterator.next();
            if (uniqueEmployeeMap.containsKey(employee.getId())) {
                duplicatesList.add(employee);
                iterator.remove();
            } else {
                uniqueEmployeeMap.put(employee.getId(), employee);
            }
        }
        System.out.println(employeeList);
        System.out.println("***********************");
        System.out.println("Original Employee List:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.println("\nDuplicates List:");
        for (Employee employee : duplicatesList) {
            System.out.println(employee);
        }

        System.out.println("\n Unique Employee Map:");
        for (Map.Entry<Integer, Employee> entry : uniqueEmployeeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

    }
    }
    //Bu işlem sonucunda, employeeList içinde sadece benzersiz çalışanlar kalırken, aynı id'ye sahip olan çalışanlar
    // duplicatesList listesine eklenir ve orijinal listesinden kaldırılır. Bu tür bir işlem, özellikle bir liste içinde
    // benzersiz elemanları korumak istediğinizde veya benzersiz olmayanları kontrol etmek istediğinizde kullanışlıdır.


}