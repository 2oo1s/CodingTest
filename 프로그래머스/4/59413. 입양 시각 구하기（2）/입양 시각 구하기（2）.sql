-- 코드를 입력하세요
WITH TIME AS 
(
    SELECT LEVEL -1 HOUR
    FROM DUAL
    CONNECT BY LEVEL <= 24
),

ANI AS
(
    SELECT ANIMAL_ID, TO_CHAR(DATETIME, 'HH24') HOUR
    FROM ANIMAL_OUTS
)

SELECT T.HOUR, COUNT(ANIMAL_ID) COUNT
FROM TIME T LEFT OUTER JOIN ANI A ON T.HOUR = A.HOUR
GROUP BY T.HOUR
ORDER BY 1;