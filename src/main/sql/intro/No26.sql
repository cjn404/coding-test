/*
📌 No26. 입양 시각 구하기(1) (답안 2가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59412

📝 문제 설명:
ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. ANIMAL_OUTS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다.
보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 09:00부터 19:59까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 이때 결과는 시간대 순으로 정렬해야 합니다.
*/

-- 1. 정수 기반
SELECT HOUR(DATETIME) AS HOUR,
    COUNT(*) AS COUNT
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) BETWEEN 9 AND 19
GROUP BY HOUR(DATETIME)
ORDER BY HOUR;

-- 2. 문자열 기반
SELECT DATE_FORMAT(DATETIME, '%H') AS HOUR,
    COUNT(*) AS COUNT
FROM ANIMAL_OUTS
WHERE DATE_FORMAT(DATETIME, '%H') BETWEEN '09' AND '19'
GROUP BY DATE_FORMAT(DATETIME, '%H')
ORDER BY HOUR;