# Write your MySQL query statement below

select tmp.customer_id from
(select customer_id,count(distinct product_key) as cnt
from Customer 
group by customer_id) tmp
where tmp.cnt = (select count(product_key) from Product);
