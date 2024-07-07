# Write your MySQL query statement below

select query_name,round(sum(q.rating/q.position) / count(q.rating),2) as quality,
round(((SUM(CASE WHEN q.rating < 3 THEN 1 ELSE 0 END)) / count(q.rating))*100,2) as  poor_query_percentage
from Queries q
where q.query_name is not null
group by q.query_name;