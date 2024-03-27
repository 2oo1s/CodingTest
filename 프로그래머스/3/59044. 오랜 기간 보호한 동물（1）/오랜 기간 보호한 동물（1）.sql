-- 코드를 입력하세요
SELECT A.NAME, A.DATETIME
FROM (SELECT *
      FROM ANIMAL_INS
      ORDER BY DATETIME) A LEFT OUTER JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.DATETIME IS NULL AND ROWNUM <= 3
ORDER BY A.DATETIME;