# Write your MySQL query statement below

select COALESCE(e2.name, 'NULL') as name
from Employee E1
left join Employee E2
on E1.managerId = E2.id
group by e2.id
having count(e1.id) >= 5;