package com.example;

public class EmployeeDB {

    /**
     * Write a query to display the first_name, last_name, birth_date and hire_date of employee. 
     * Display in sorted order of first_name and within that sort by last_name.
     * @return
     */
    public String problem1() {
        return " SELECT first_name, last_name, birth_date, " +
                "hire_date FROM employees ORDER BY first_name, last_name; ";
    }

    /**
     * Write a query to display employees who were hired after year 1995.
     * @return
     */
    public String problem2() {
        return " SELECT * FROM employees WHERE EXTRACT(year FROM hire_date) > 1995; ";
    }

    /**
     * Write a query to display employees who worked at Marketing department. 
     * Display department name, employee’s first_name, last_name and 
     * work periods (from_date, to_date) when one employee worked at Marketing department.
     * @return
     */
    public String problem3() {
        return "SELECT dept_name, first_name, last_name, from_date, to_date FROM departments"  +
        "INNER JOIN dept_emp ON departments.dept_no = dept_emp.dept_no " +
        "INNER JOIN employees ON dept_emp.emp_no = employees.emp_no " +
        "WHERE departments.dept_name = 'Marketing';";
    }

    /**
     * Write a query to show hired employee counts each year. 
     * Display year as the hire year, hire_count as the counts each year hired.
     * @return
     */
    public String problem4() {
        return "SELECT EXTRACT(year FROM hire_date) AS year, COUNT(*) as hire_count" +
        "FROM employees" +
        "GROUP BY  EXTRACT(year FROM hire_date);";
    }
}
