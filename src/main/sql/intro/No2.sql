/*
📌 No2. 역순 정렬하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59035

📝 문제 설명:
NIMAL_INS 테이블에서 ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.
동물 보호소에 들어온 모든 동물의 이름과 보호 시작일을 조회하고, ANIMAL_ID 역순으로 정렬된 SQL문을 작성해주세요.
*/

SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;
