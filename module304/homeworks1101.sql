-- I want to see all the employees that do not have any customers - subquery using 'not in'

select distinct sales_rep_employee_id from customers where sales_rep_employee_id IS NOT NULL;

select *
from employees
where id NOT IN (select distinct sales_rep_employee_id from customers where sales_rep_employee_id IS NOT NULL);

-- I want to see all the customers that have not made an order - subquery using not in
select distinct customer_id
from orders;

select *
from customers
where id NOT IN (select distinct customer_id from orders);

-- I want to see all of the products that have never been ordered - subquery using not in
select *
from products
where id NOT IN (select distinct product_id from orderdetails);

-- I want to see all customers that have made an order that has more than 3 products
-- in the order regardless of quantity
-- I think this can be done using a subquery in the having
select c.id CustomerId, count(od.product_id) TotalProductPurchased
from customers c, orders o, orderdetails od
where c.id = o.customer_id and o.id = od.order_id
group by c.id
having TotalProductPurchased > 3;

-- I want to see any customer that has made an order greater than $50,000 - this subquery in having
select distinct c.id CustomerId
from customers c, orders o, orderdetails od
where c.id = o.customer_id and o.id = od.order_id
group by c.id, o.id
having sum(od.quantity_ordered*od.price_each) > 50000;

select c.id CustomerId, o.id OrderId, sum(od.quantity_ordered*od.price_each) TotalOrder
from customers c, orders o, orderdetails od
where c.id = o.customer_id and o.id = od.order_id
group by c.id, o.id
having TotalOrder > 50000;

-- I want to see all orders and the number of products in that order and
-- the total number of quantity ordered for that order .. HOWEVER ..
-- I want the product count and the total quantity order done as subqueries in the select statement.
-- Do not use a  group by in the outer query
