-- 코드를 입력하세요
SELECT P.PRODUCT_ID, PRODUCT_NAME, SUM(PRICE * AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT P LEFT JOIN FOOD_ORDER O ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE TO_CHAR(O.PRODUCE_DATE, 'YYYYMM') = '202205'
GROUP BY P.PRODUCT_ID, PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID;