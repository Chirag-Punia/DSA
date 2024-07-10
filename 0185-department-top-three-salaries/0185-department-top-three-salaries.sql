

select d.name as Department,e.name as Employee,e.salary
from Employee e
left join Department d
on e.departmentId = d.id
where (
    select count(distinct e2.salary)
    from Employee e2
    where e2.departmentId = e.departmentId
    and e.salary < e2.salary
)<3;