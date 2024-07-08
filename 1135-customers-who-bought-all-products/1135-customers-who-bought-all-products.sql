# Write your MySQL query statement below
select tmp.customer_id
from
(select c.customer_id,count(distinct c.product_key) as cnt
from Customer c
group by c.customer_id) tmp
where tmp.cnt = (select count(p.product_key) from Product p);
