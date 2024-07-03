# Write your MySQL query statement below

#length count bytes
#char_length count characters
select tweet_id
from Tweets
where char_length(content) > 15;