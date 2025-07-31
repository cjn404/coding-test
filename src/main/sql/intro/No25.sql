/*
📌 No25. 고양이와 개는 몇 마리 있을까 (답안 2가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59040

📝 문제 설명:
ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.
동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요. 이때 고양이를 개보다 먼저 조회해주세요.
*/

-- 1. 알파벳순(오름차순) 정렬
SELECT ANIMAL_TYPE,
       COUNT(*) AS count
FROM ANIMAL_INS
WHERE ANIMAL_TYPE IN ('Cat', 'Dog')
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;

-- 2. 명시적으로 정렬 우선순위 지정
SELECT ANIMAL_TYPE,
       COUNT(*) AS count
FROM ANIMAL_INS
WHERE ANIMAL_TYPE IN ('Cat', 'Dog')
GROUP BY ANIMAL_TYPE
ORDER BY CASE ANIMAL_TYPE
    WHEN 'Cat' THEN 1
    WHEN 'Dog' THEN 2
END;
