-- 코드를 입력하세요
WITH APNT AS
(
SELECT APNT_YMD, APNT_NO, A.PT_NO, MCDP_CD, MDDR_ID, APNT_CNCL_YN, APNT_CNCL_YMD, PT_NAME
FROM APPOINTMENT A LEFT OUTER JOIN PATIENT B ON A.PT_NO = B.PT_NO
WHERE TO_CHAR(APNT_YMD,'YYYYMMDD') = '20220413' AND APNT_CNCL_YN = 'N'
)

SELECT APNT_NO, PT_NAME, PT_NO, A.MCDP_CD, DR_NAME, APNT_YMD
FROM APNT A INNER JOIN DOCTOR B ON A.MDDR_ID = B.DR_ID
ORDER BY 6;