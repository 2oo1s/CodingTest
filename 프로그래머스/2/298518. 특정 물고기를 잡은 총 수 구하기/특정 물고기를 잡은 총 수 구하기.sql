-- 코드를 작성해주세요
SELECT COUNT(ID) FISH_COUNT
FROM FISH_INFO A INNER JOIN (SELECT *
                             FROM FISH_NAME_INFO
                             WHERE FISH_NAME IN ('BASS', 'SNAPPER')) B
                             ON A.FISH_TYPE = B.FISH_TYPE