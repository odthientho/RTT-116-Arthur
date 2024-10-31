-- select from order by
SELECT order_id, order_line_number, quantity_ordered * price_each
FROM orderdetails
ORDER BY
    quantity_ordered * price_each DESC;

-- as subtotal
SELECT
    order_id,
    order_line_number,
    quantity_ordered * price_each AS subtotal
FROM    orderdetails
ORDER BY subtotal DESC;

-- null values
SELECT    firstName, lastname, reports_to
FROM    employees
ORDER BY reports_to;