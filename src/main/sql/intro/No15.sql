/*
📌 No15. NULL 처리하기 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59410

📝 문제 설명:
ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.
입양 게시판에 동물 정보를 게시하려 합니다. 동물의 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요. 이때 프로그래밍을 모르는 사람들은 NULL이라는 기호를 모르기 때문에, 이름이 없는 동물의 이름은 "No name"으로 표시해 주세요.
*/

-- 1. IFNULL 사용
SELECT ANIMAL_TYPE,
       IFNULL(NAME, 'No name') AS NAME,
       SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- 2. IF 함수 사용
SELECT ANIMAL_TYPE,
       IF(NAME IS NULL, 'No name', NAME) AS NAME,
       SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- 3. CASE 사용
SELECT ANIMAL_TYPE,
       CASE
           WHEN NAME IS NULL THEN 'No name'
           ELSE NAME
           END AS NAME,
       SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;