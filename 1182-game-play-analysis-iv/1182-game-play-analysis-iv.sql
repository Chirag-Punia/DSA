# Write your MySQL query statement below

select round(count(tmp.player_id) / count(distinct a.player_id),2) as fraction
from Activity a
left join 
(select a.player_id,min(a.event_date) as event_date
from Activity a
group by a.player_id) tmp
on a.player_id = tmp.player_id
and date_sub(a.event_date,interval 1 day) = tmp.event_date;

