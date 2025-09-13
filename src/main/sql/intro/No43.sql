/*
📌 No43. 조건에 맞는 사용자와 총 거래금액 조회하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/164668

📝 문제 설명:
USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문을 작성해주세요. 결과는 총거래금액을 기준으로 오름차순 정렬해주세요.
*/

SELECT U.USER_ID,
       U.NICKNAME,
       SUM(B.PRICE) TOTAL_SALES
FROM USED_GOODS_BOARD B
         JOIN USED_GOODS_USER U ON B.WRITER_ID = U.USER_ID
WHERE B.STATUS = 'DONE'
GROUP BY U.USER_ID, U.NICKNAME
HAVING SUM(B.PRICE) >= 700000
ORDER BY TOTAL_SALES;