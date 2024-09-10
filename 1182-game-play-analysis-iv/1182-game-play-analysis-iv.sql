

select round(sum(case when tmp.player_id is not null then 1 else 0 end)/count(distinct T.player_id),2) as fraction
from Activity T
left join
(select A.player_id, min(A.event_date) as x
from Activity A
group by A.player_id) tmp
on T.player_id = tmp.player_id and T.event_date - interval 1 day = tmp.x;


 
