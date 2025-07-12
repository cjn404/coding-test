/*
📌 No5. 동물 수 구하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59406

📝 문제 설명:
NIMAL_INS 테이블에서 ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.
동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문을 작성해주세요.
*/

SELECT COUNT(*) AS count
FROM ANIMAL_INS;