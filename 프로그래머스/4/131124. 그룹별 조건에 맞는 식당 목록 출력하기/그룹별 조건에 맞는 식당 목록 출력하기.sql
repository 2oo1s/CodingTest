-- 코드를 입력하세요.
SELECT MEMBER_NAME, REVIEW_TEXT, TO_CHAR(REVIEW_DATE, 'YYYY-MM-DD')
FROM REST_REVIEW A INNER JOIN MEMBER_PROFILE B ON A.MEMBER_ID = B.MEMBER_ID
WHERE A.MEMBER_ID IN (SELECT MEMBER_ID
                      FROM REST_REVIEW
                      GROUP BY MEMBER_ID
                      HAVING COUNT(REVIEW_ID) = (SELECT MAX(COUNT(REVIEW_ID))
                                                 FROM REST_REVIEW
                                                 GROUP BY MEMBER_ID))
ORDER BY 3, 2;