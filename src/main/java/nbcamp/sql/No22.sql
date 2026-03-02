/*
📌 No22. 조건에 맞는 회원수 구하기 (답안 2가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131535

📝 문제 설명:
다음은 어느 의류 쇼핑몰에 가입한 회원 정보를 담은 USER_INFO 테이블입니다. USER_INFO 테이블은 아래와 같은 구조로 되어있으며 USER_ID, GENDER, AGE, JOINED는 각각 회원 ID, 성별, 나이, 가입일을 나타냅니다.
USER_INFO 테이블에서 2021년에 가입한 회원 중 나이가 20세 이상 29세 이하인 회원이 몇 명인지 출력하는 SQL문을 작성해주세요.
*/

SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE BETWEEN 20 AND 29 AND YEAR(JOINED) = 2021 ;

SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE >= 20 AND AGE <= 29 AND YEAR(JOINED) = 2021 ;