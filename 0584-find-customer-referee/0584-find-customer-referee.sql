# Write your MySQL query statement below
-- select name from Customer where referee_id <> 2 or referee_id is null;
-- select name from Customer where ifnull(referee_id ,-1) <> 2;
select name from Customer where coalesce(referee_id ,-1) <> 2;