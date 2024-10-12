-- 코드를 입력하세요
SELECT TO_NUMBER(TO_CHAR(SALES_DATE, 'YYYY')) YEAR, TO_NUMBER(TO_CHAR(SALES_DATE, 'MM')) MONTH,
        GENDER, COUNT(DISTINCT U.USER_ID) USERS
FROM ONLINE_SALE O LEFT OUTER JOIN USER_INFO U ON O.USER_ID = U.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY TO_NUMBER(TO_CHAR(SALES_DATE, 'YYYY')), TO_NUMBER(TO_CHAR(SALES_DATE, 'MM')), GENDER
ORDER BY 1,2,3;