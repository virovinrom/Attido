

--a
SELECT orders.Description AS 'Order Description', order_lines.Number AS 'Line Number', items.Description AS 'Item Description',
items.Price * order_lines.Quantity AS 'Price', items.Weight * order_lines.Quantity AS 'Weight'
FROM orders
JOIN order_lines ON order_lines.Order_ID=orders.id
JOIN items ON items.id=order_lines.Item_ID

--b
SELECT
orders.Description AS 'Description',
SUM(items.Price * order_lines.Quantity) AS 'Total price',
SUM(order_lines.Quantity) AS 'Total quantity'
FROM orders
JOIN order_lines ON order_lines.Order_ID=orders.id
JOIN items ON items.id=order_lines.Item_ID
GROUP BY orders.Description

--c
SELECT
orders.Description AS 'Description',
SUM(items.Price * order_lines.Quantity) AS 'Price'
FROM orders
JOIN order_lines ON order_lines.Order_ID=orders.id
JOIN items ON items.id=order_lines.Item_ID
GROUP BY orders.Description
ORDER BY Price DESC
LIMIT 1

--d
SELECT
orders.Description AS 'Description',
COUNT(Description) AS 'Lines',
COUNT(DISTINCT order_lines.Item_ID) AS 'Items amount'
FROM orders
JOIN order_lines ON order_lines.Order_ID=orders.id
WHERE orders.End_date IS NULL
GROUP BY orders.Description