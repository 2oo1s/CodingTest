-- 코드를 작성해주세요
SELECT A.DEPT_ID, A.DEPT_NAME_EN, AVG_SAL
FROM HR_DEPARTMENT A INNER JOIN (SELECT DEPT_ID, ROUND(AVG(SAL)) AVG_SAL
                                      FROM HR_EMPLOYEES
                                      GROUP BY DEPT_ID) B ON A.DEPT_ID = B.DEPT_ID
ORDER BY 3 DESC;