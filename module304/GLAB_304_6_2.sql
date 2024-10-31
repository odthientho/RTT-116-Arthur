-- For each product, show the product name "Product" and the product type name "Type.
select products.product_name, productlines.product_line
from products, productlines
where productline_id = productlines.id;

-- For each branch, list the branch name and city, plus the last name
-- and title of each employee who works in that branch.
select o.city, e.lastname, e.job_title
from offices o, employees e
where o.id = e.office_id;

SELECT distinct job_title FROM employees;

-- Show the last name and title of each employee, along with the last name
-- and title of that employee's boss.
select e.lastname, e.job_title, m.lastname, m.job_title
from employees e, employees m
where e.reports_to = m.id;