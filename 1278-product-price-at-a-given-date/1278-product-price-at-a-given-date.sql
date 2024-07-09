
with data as 
    (select * , datediff("2019-08-16",change_date) as diff 
    from Products)

select d.product_id , (case when (sum(
    (case when 
    tmp.minDiff = d.diff 
    then d.new_price 
    else 0 end)
    )) = 0 then 10 else (
    sum(
    (case when 
    tmp.minDiff = d.diff 
    then d.new_price 
    else 0 end)
    )
    )end)
    as price
from data d
left join(
    select d.product_id,min(d.diff) as minDIFF
    from data d
    where d.diff >= 0
    group by d.product_id) tmp
on d.product_id = tmp.product_id
group by product_id;