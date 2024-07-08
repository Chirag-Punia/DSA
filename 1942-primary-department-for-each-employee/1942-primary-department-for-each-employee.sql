# Write your MySQL query statement below


select e.employee_id,e.department_id
from Employee e
left join
(select *,count(e.primary_flag) as cnt
from Employee e
group by e.employee_id) tmp
on e.employee_id = tmp.employee_id
where tmp.cnt = 1 
or e.primary_flag = 'Y';