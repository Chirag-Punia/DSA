# Write your MySQL query statement below
with resOrder as(
select *, sum(unit) as total
from Orders 
where month(order_date) = 2 and year(order_date) = 2020
group by product_id
having total >= 100)


select p.product_name,r.total as unit
from Products p
left join resOrder r
on p.product_id = r.product_id
where r.total is not null;