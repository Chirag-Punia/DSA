# Write your MySQL query statement below
select t.teacher_id , count(distinct t.subject_id) as cnt
from Teacher t
group by 1;