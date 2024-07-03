# Write your MySQL query statement below

#length count bytes
#char_length count characters
SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15;