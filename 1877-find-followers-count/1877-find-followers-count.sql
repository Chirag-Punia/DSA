# Write your MySQL query statement below
select f.user_id,count(f.user_id) as followers_count
from Followers f
group by f.user_id
order by user_id asc;