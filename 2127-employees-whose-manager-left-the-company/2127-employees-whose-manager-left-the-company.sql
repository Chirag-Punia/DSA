# Write your MySQL query statement below

select E.employee_id
from Employees E
where E.salary < 30000
and E.manager_id  not in (select manager_id from Employees)
order by employee_id;