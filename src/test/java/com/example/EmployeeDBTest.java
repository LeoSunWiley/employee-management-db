package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeDBTest {
    
    private EmployeeDB employeeDB;

    @BeforeEach
    public void setUp() {
        this.employeeDB = new EmployeeDB();
    }

    @Test
    @DisplayName("Problem1 - Test case")
    public void problem1() {
        String expected = "SELECT first_name, last_name, birth_date, hire_date FROM employees ORDER BY first_name, last_name;";
        String result = employeeDB.problem1();

        assertEquals(StringUtils.deleteWhitespace(expected), StringUtils.deleteWhitespace(result));
    }

    @Test
    @DisplayName("Probelm2 - Test case")
    public void problem2() {
        String expected = "SELECT * FROM employees WHERE EXTRACT(year FROM hire_date) > 1995;";
        String result = employeeDB.problem2();

        assertEquals(StringUtils.deleteWhitespace(expected), StringUtils.deleteWhitespace(result));
    }

    @Test
    @DisplayName("Problem3 - Test case")
    public void problem3() {
        String expected = """
            SELECT dept_name, first_name, last_name, from_date, to_date FROM departments 
        INNER JOIN dept_emp ON departments.dept_no = dept_emp.dept_no 
        INNER JOIN employees ON dept_emp.emp_no = employees.emp_no 
        WHERE departments.dept_name = 'Marketing';
        """;
        String result = employeeDB.problem3();

        assertEquals(StringUtils.deleteWhitespace(expected), StringUtils.deleteWhitespace(result));
    }

    @Test
    @DisplayName("Problem4 - Test case")
    public void problem4() {
        String expected = "SELECT EXTRACT(year FROM hire_date) AS year, COUNT(*) as hire_count FROM employees GROUP BY  EXTRACT(year FROM hire_date);";
        String result = employeeDB.problem4();

        assertEquals(StringUtils.deleteWhitespace(expected), StringUtils.deleteWhitespace(result));
    }
}
