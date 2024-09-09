# Write your MySQL query statement below

select e2.name
from Employee E1
left join Employee E2
on E1.managerId = E2.id
group by e2.id,e2.name
having count(e1.id) >= 5;