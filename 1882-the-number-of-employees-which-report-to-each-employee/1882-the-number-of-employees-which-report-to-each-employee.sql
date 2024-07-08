# Write your MySQL query statement below
select e.employee_id,e.name,tmp.cnt as reports_count,tmp.aavvgg as average_age
from Employees e
join(
    select * ,count(e.reports_to) as cnt, round(avg(e.age)) as aavvgg
    from Employees e
    group by e.reports_to
    having count(e.reports_to>=1)
    ) tmp
on e.employee_id = tmp.reports_to
order by employee_id;
