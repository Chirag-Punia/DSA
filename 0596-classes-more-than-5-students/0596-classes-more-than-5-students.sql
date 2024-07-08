select class
from 
(select class,count(class) as cnt
from Courses 
group by class) tmp
where tmp.cnt >= 5;
