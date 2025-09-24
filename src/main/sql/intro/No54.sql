/*
📌 No54. 최댓값 구하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59415

📝 문제 설명:
가장 최근에 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.
*/

SELECT DATETIME AS 시간
FROM ANIMAL_INS
ORDER BY DATETIME DESC LIMIT 1;