/*
📌 No16. 경기도에 위치한 식품창고 목록 출력하기 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131114

📝 문제 설명:
다음은 식품창고의 정보를 담은 FOOD_WAREHOUSE 테이블입니다. FOOD_WAREHOUSE 테이블은 다음과 같으며 WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, TLNO, FREEZER_YN는 창고 ID, 창고 이름, 창고 주소, 전화번호, 냉동시설 여부를 의미합니다.
FOOD_WAREHOUSE 테이블에서 경기도에 위치한 창고의 ID, 이름, 주소, 냉동시설 여부를 조회하는 SQL문을 작성해주세요. 이때 냉동시설 여부가 NULL인 경우, 'N'으로 출력시켜 주시고 결과는 창고 ID를 기준으로 오름차순 정렬해주세요.
*/

SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       IFNULL(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID;

SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       IF(FREEZER_YN IS NULL, 'N', FREEZER_YN) AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID;

SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       CASE
           WHEN FREEZER_YN IS NULL THEN 'N'
           ELSE FREEZER_YN
           END AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID;