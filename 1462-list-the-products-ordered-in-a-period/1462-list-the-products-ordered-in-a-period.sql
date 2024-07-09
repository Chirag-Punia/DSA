WITH resOrder AS (
    SELECT
        product_id,
        SUM(unit) AS total
    FROM
        Orders
    WHERE
        MONTH(order_date) = 2
        AND YEAR(order_date) = 2020
    GROUP BY
        product_id
    HAVING
        total >= 100
)

SELECT
    p.product_name,
    COALESCE(r.total, 0) AS unit
FROM
    Products p
LEFT JOIN
    resOrder r ON p.product_id = r.product_id
WHERE
    r.total IS NOT NULL;
