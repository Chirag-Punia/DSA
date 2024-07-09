# Write your MySQL query statement below

select (case when s.id%2=0 then s.id-1
when s.id%2<>0 and s.id=(select max(id) from Seat)
then s.id else s.id+1 end) as id,s.student
from Seat s
order by id;