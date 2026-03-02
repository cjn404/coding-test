/*
📌 No60. 년, 월, 성별 별 상품 구매 회원 수 구하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131532

📝 문제 설명:
USER_INFO 테이블과 ONLINE_SALE 테이블에서 년, 월, 성별 별로 상품을 구매한 회원수를 집계하는 SQL문을 작성해주세요. 결과는 년, 월, 성별을 기준으로 오름차순 정렬해주세요. 이때, 성별 정보가 없는 경우 결과에서 제외해주세요.
*/

SELECT
    YEAR(OS.SALES_DATE)  AS SALES_YEAR,
    MONTH(OS.SALES_DATE) AS SALES_MONTH,
    UI.GENDER,
    COUNT(DISTINCT OS.USER_ID) AS USER_COUNT
FROM USER_INFO UI
    JOIN ONLINE_SALE OS
ON UI.USER_ID = OS.USER_ID
WHERE UI.GENDER IS NOT NULL
  AND UI.GENDER IN (0, 1)
GROUP BY
    YEAR(OS.SALES_DATE),
    MONTH(OS.SALES_DATE),
    UI.GENDER
ORDER BY
    SALES_YEAR,
    SALES_MONTH,
    UI.GENDER;