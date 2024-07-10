# Write your MySQL query statement below


select round(sum(i.tiv_2016),2) as tiv_2016
from Insurance i
where (lat,lon) in(
    select lat,lon
    from Insurance 
    group by lat,lon
    having count(*) = 1
)
and
tiv_2015 in
(
select tiv_2015
from Insurance 
group by tiv_2015
having count(*) > 1
);



-- select sum(tiv_2016) as tiv_2016
-- from tmp
-- group by tiv_2015
-- having tiv_2015 <> tiv_2016;
