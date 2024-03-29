-- 코드를 입력하세요
WITH MAX_INFO AS
(
SELECT CATEGORY, MAX(PRICE) MAX_PRICE
FROM FOOD_PRODUCT
WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
GROUP BY CATEGORY
)

SELECT B.CATEGORY, B.MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT A INNER JOIN MAX_INFO B ON A.PRICE = B.MAX_PRICE
WHERE A.CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY 2 DESC;
