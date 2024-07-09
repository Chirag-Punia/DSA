# Write your MySQL query statement below


select tmp.user_name as results
from
(select u.name as user_name, count(u.user_id) as cnt
from MovieRating M
left join Users u
on M.user_id = u.user_id
group by u.name
order by cnt desc, u.name
limit 1) as tmp
union all
select xmp.name_or_title as results
from
(select mov.title as name_or_title ,avg(M.rating) as metric
from MovieRating M
left join Movies mov
on M.movie_id = mov.movie_id
where month(M.created_at) = 2 and year(M.created_at) = 2020
group by mov.title
order by metric desc, name_or_title asc
limit 1) as xmp


