# Write your MySQL query statement below
select distinct tmp.category,count(t.account_id) as accounts_count
from
(select "Low Salary" as category 
union select "Average Salary" 
union select "High Salary") tmp
left join
(select *,(
    case when a.income > 50000 then "High Salary"
    when a.income between 20000 and 50000 then "Average Salary"
    when a.income < 20000 then "Low Salary"
 end) as category
from Accounts a) t
on t.category = tmp.category
group by tmp.category;


