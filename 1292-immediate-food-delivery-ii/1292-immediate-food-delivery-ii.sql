# Write your MySQL query statement below
select round((sum(case when d.customer_pref_delivery_date = tmp.x then 1 else 0 end) / count(distinct d.customer_id))*100,2) as immediate_percentage 
from Delivery d
join 
(select d.customer_id,min(d.order_date) as x
from Delivery d
group by d.customer_id) tmp
on d.customer_id = tmp.customer_id;
