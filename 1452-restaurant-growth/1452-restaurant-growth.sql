# Write your MySQL query statement below

with cstmr as 
(select c.visited_on , sum(c.amount) as sum
from Customer c
group by c.visited_on)

select c1.visited_on , sum(c2.sum) as amount ,round(avg(c2.sum),2) as average_amount
from cstmr c1
left join cstmr c2
on c1.visited_on >= c2.visited_on
where datediff(c1.visited_on,c2.visited_on) between 0 and 6
and c1.visited_on >= date_add((select min(visited_on) from cstmr) ,interval 6 day)
group by c1.visited_on
order by c1.visited_on;

