/*
📌 No17. 강원도에 위치한 생산공장 목록 출력하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131112

📝 문제 설명:
다음은 식품공장의 정보를 담은 FOOD_FACTORY 테이블입니다. FOOD_FACTORY 테이블은 다음과 같으며 FACTORY_ID, FACTORY_NAME, ADDRESS, TLNO는 각각 공장 ID, 공장 이름, 주소, 전화번호를 의미합니다.
FOOD_FACTORY 테이블에서 강원도에 위치한 식품공장의 공장 ID, 공장 이름, 주소를 조회하는 SQL문을 작성해주세요. 이때 결과는 공장 ID를 기준으로 오름차순 정렬해주세요.
*/

SELECT FACTORY_ID,
       FACTORY_NAME,
       ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원도%'
ORDER BY FACTORY_ID;