package ru.mirea.t9;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company cumpany = new Company();
        Random r = new Random(100000);

        for (int i = 0; i < 100; i++) {
            cumpany.hire(new Employee("Ilya", "Sir Eda", "Obshaga", r.nextInt(10000000), new Dates(06, 06, 2006)));
        }

        cumpany.doSomethingWithEmployee(
                new UsageInterface(8402391),
                (employee, i) -> System.out.println("employee " + i + ":" + employee));

        int m = 20_000;
        cumpany.doSomethingWithEmployee(new EmployeeSelector() {
            @Override
            public boolean isNeedEmployee(Employee employee) {
                return employee.getNumber() < m;
            }
        }, new EmployeeHandler() {
            @Override
            public void handleEmployees(Employee employee, int index) {
                System.out.println("=====" + index + "======");
                System.out.println(employee);
            }
        });

        ArrayList<Employee> selection = new ArrayList<>();
        cumpany.doSomethingWithEmployee(
                employee -> employee.getNumber() > 1_000_000,
                (employee, i) -> selection.add(employee));
        System.out.println(selection + "selection");

        EmployeeSelector selector = employee -> employee.getNumber() > 200;
        cumpany.doSomethingWithEmployee(
                selector,
                Main::doSome);

        cumpany.fire(90);
        System.out.println("90% of Ilyas has been destroyed by world cataclysm");
        System.out.println("Survived Ilyas:");
        for (int i = 0; i < cumpany.getEmployeeList().size(); i++) {
            System.out.println(cumpany.getEmployeeList().get(i));
        }
    }

    static void doSome(Employee employee, int index) {
        System.out.println("++++++" + index + "++++");
        System.out.println(employee);
    }
}