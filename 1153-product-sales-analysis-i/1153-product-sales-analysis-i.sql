# Write your MySQL query statement below

select s.price, s.year, p.product_name
from Sales s
left join Product p
on s.product_id = p.product_id;
