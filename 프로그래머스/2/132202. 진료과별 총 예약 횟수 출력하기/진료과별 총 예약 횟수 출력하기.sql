-- 코드를 입력하세요
SELECT mcdp_cd "진료과코드", COUNT(PT_NO) "5월예약건수"
FROM APPOINTMENT
WHERE TO_CHAR(APNT_YMD, 'yyyymm') = '202205'
GROUP BY mcdp_cd
ORDER BY 2, 1;