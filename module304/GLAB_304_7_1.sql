SELECT  * FROM  departments
WHERE  location_id = 1700;

SELECT  employee_id, first_name, last_name, department_id
FROM   employees
WHERE  department_id IN (1, 3, 9, 10, 11)
ORDER BY first_name, last_name;

SELECT   employee_id, first_name, last_name, department_id
FROM employees
WHERE department_id IN (SELECT department_id
                        FROM      departments
                        WHERE location_id = 1700)
ORDER BY first_name, last_name;

SELECT employee_id, first_name, last_name, department_id
FROM  employees
WHERE  department_id NOT IN (SELECT department_id
                             FROM   departments
                             WHERE location_id = 1700)
ORDER BY first_name , last_name;

SELECT employee_id, first_name, last_name, salary
FROM   employees
WHERE salary = (SELECT MAX(salary) FROM  employees)
ORDER BY first_name, last_name;

SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary)FROM employees);

SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary)FROM employees);

SELECT department_name
FROM departments d
WHERE NOT EXISTS ( SELECT * FROM employees e
                   WHERE salary > 10000 AND e.department_id = d.department_id) ORDER BY department_name;

