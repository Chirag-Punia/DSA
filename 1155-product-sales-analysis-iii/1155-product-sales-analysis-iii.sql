# Write your MySQL query statement below

select s.product_id,s.year as first_year,s.quantity,s.price
from Sales s
left join
(select s.product_id,min(s.year) as first_year
from Sales s
group by s.product_id) tmp
on s.product_id = tmp.product_id where s.year = tmp.first_year;