SELECT    customer_name, country
FROM    customers
WHERE    country = 'USA' OR country = 'France';

SELECT    customer_name, country, credit_limit
FROM    customers
WHERE (country = 'USA' OR country = 'France') AND credit_limit > 100000;

SELECT product_code,  product_name,  buy_price
FROM    products
WHERE     buy_price BETWEEN 90 AND 100;

SELECT product_code, product_name, buy_price
FROM products
WHERE  buy_price >= 90 AND buy_price <= 100;

SELECT customer_name, country, sales_rep_employee_id
FROM customers
WHERE sales_rep_employee_id IS NULL
ORDER BY  customer_name;