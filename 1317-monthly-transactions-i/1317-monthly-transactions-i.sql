# Write your MySQL query statement below



select date_format(T.trans_date, '%Y-%m') as month,T.country,count(t.id) as trans_count,sum(case when T.state = 'approved' then 1 else 0 end) as approved_count,sum(T.amount) as trans_total_amount,sum(case when T.state = 'approved' then T.amount else 0 end ) as approved_total_amount 
from Transactions T
group by date_format(T.trans_date, '%Y-%m'),T.country;

