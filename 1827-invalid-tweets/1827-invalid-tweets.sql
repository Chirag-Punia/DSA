# Write your MySQL query statement below

#length count bytes
#char_length count characters
select tweet_id
from Tweets
where Char_length(content) > 15;