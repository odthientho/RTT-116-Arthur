SELECT order_id, SUM(quantity_ordered) as Qty,
       IF(MOD(SUM(quantity_ordered),2),'Odd', 'Even') as oddOrEven
FROM    orderdetails
GROUP BY    order_id
ORDER BY    order_id;


SELECT TRUNCATE(1.555,1);

SELECT product_id, AVG(quantity_ordered * price_each) as avg_order_value
FROM orderdetails
GROUP BY product_id;

SELECT YEAR(shipped_date) as year,  COUNT(id) as orderQty
FROM    orders
GROUP BY YEAR(shipped_date)
ORDER BY YEAR(shipped_date);
