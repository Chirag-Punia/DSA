with cnt as(
select requester_id,accepter_id
from RequestAccepted

union all

select accepter_id,requester_id
from RequestAccepted)

select c.requester_id as id,count(c.requester_id) as num
from cnt c
group by c.requester_id
order by num desc
limit 1;
