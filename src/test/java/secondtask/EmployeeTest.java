package secondtask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {


    @Test
    public void taxCalcIfSalaryBetweenLimit() {
        Employee employee = new Employee("firstNameTest", "lastNameTest", 2000, 500);
        assertEquals(528, employee.getTax());
    }

    @Test
    public void taxCalcIfSalaryHigherThenLimits() {
        Employee employee = new Employee("firstNameTest", "lastNameTest", 10000, 500);
        assertEquals(3280, employee.getTax());
    }

    @Test
    public void taxCalcIfSalaryLowerThenLimits() {
        Employee employee = new Employee("firstNameTest", "lastNameTest", 100, 500);
        assertEquals(50, employee.getTax());
    }


    @Test
    public void updateTaxIncreasedSalaryWithNoMultiplierTest() {
        Employee employee = new Employee("firstNameTest", "firstNameTest", 100, 2000);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("firstNameTest", "firstNameTest", 2000, 500));
        employees.add(new Employee("firstNameTest2", "firstNameTest2", 4000, 200));
        List<Employee> employeesUpdated = employee.updateSalary(employees, 100, 5000, 1.1);
        assertEquals(2200, employeesUpdated.get(0).getSalary());
    }

    @Test
    public void updateTaxIncreasedSalaryWithMultiplierTest() {
        Employee employee = new Employee("firstNameTest", "firstNameTest", 100, 2000);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("firstNameTest", "firstNameTest", 300, 50));
        employees.add(new Employee("firstNameTest2", "firstNameTest2", 4000, 200));
        List<Employee> employeesUpdated = employee.updateSalary(employees, 100, 5000, 1.1);
        assertEquals(324, employeesUpdated.get(0).getSalary());
    }

    @Test
    public void updateTaxIncreasedSalaryButNotInSalaryRangeTest() {
        Employee employee = new Employee("firstNameTest", "firstNameTest", 100, 2000);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("firstNameTest", "firstNameTest", 3000, 50));
        employees.add(new Employee("firstNameTest2", "firstNameTest2", 4000, 200));
        List<Employee> employeesUpdated = employee.updateSalary(employees, 100, 3200, 1.1);
        assertEquals(3000, employeesUpdated.get(0).getSalary());
    }
}
