/*
📌 No23. 중성화 여부 파악하기 (답안 2가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59409

📝 문제 설명:
ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.
보호소의 동물이 중성화되었는지 아닌지 파악하려 합니다. 중성화된 동물은 SEX_UPON_INTAKE 컬럼에 'Neutered' 또는 'Spayed'라는 단어가 들어있습니다. 동물의 아이디와 이름, 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요. 이때 중성화가 되어있다면 'O', 아니라면 'X'라고 표시해주세요.
*/

-- 1. CASE
SELECT ANIMAL_ID,
       NAME,
       CASE
           WHEN SEX_UPON_INTAKE LIKE 'Neutered%' OR
                SEX_UPON_INTAKE LIKE 'Spayed%' THEN 'O'
           ELSE 'X'
           END AS "중성화"

-- 2. IF
SELECT ANIMAL_ID,
       NAME,
       IF(SEX_UPON_INTAKE LIKE 'Neutered%' OR SEX_UPON_INTAKE LIKE 'Spayed%', 'O', 'X') AS "중성화"
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;