# Write your MySQL query statement below

select max(tmp.num) as num
from
(select *
from MyNumbers m
group by m.num
having count(m.num) = 1) tmp;