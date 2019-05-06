package secondtask;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int bonus;

    private static final int TAX_ALLOWANCE = 100;
    private static final int TAX_LOWER_LIMIT = 500;
    private static final int TAX_UPPER_LIMIT = 4000;

    public Employee(String firstName, String lastName, int salary, int bonus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.bonus = bonus;
    }

    public static List<Employee> updateSalary(List<Employee> employeesToUpdate, int taxableSalaryBottomRange, int taxableSalaryTopRange,
                                              double salaryMultiplier) {
        for (Employee employee : employeesToUpdate) {
            if (employee.getTaxableSalary() < 3000) {
                double multiplierToDecrease = salaryMultiplier;
                while (multiplierToDecrease * employee.getSalary() - employee.getSalary() > employee.getTax()){
                    multiplierToDecrease -= 0.01;
                }
                if ((int) (multiplierToDecrease * employee.getSalary()) > taxableSalaryBottomRange &&
                        (int) (multiplierToDecrease * employee.getSalary()) < taxableSalaryTopRange) {
                    employee.setSalary((int) (multiplierToDecrease * employee.getSalary()));
                }
            }
        }
        return employeesToUpdate;
    }


    public int getTax() {
        int tax = 0;
        if (salary < TAX_LOWER_LIMIT) {
            tax =  10 * getTaxableSalary() / 100;
        } else if (salary > TAX_LOWER_LIMIT  && salary < TAX_UPPER_LIMIT) {
            tax =  22 * getTaxableSalary() / 100;
        } else if (salary > TAX_UPPER_LIMIT) {
            tax =  22 * TAX_UPPER_LIMIT / 100 + 40 * (salary - TAX_UPPER_LIMIT) / 100;
        }
        return tax;
    }

    private int getTaxableSalary() {
        return this.salary + this.bonus - TAX_ALLOWANCE;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
