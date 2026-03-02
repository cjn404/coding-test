/*
📌 No53. 재구매가 일어난 상품과 회원 리스트 구하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131536

📝 문제 설명:
ONLINE_SALE 테이블에서 동일한 회원이 동일한 상품을 재구매한 데이터를 구하여, 재구매한 회원 ID와 재구매한 상품 ID를 출력하는 SQL문을 작성해주세요. 결과는 회원 ID를 기준으로 오름차순 정렬해주시고 회원 ID가 같다면 상품 ID를 기준으로 내림차순 정렬해주세요.
*/

SELECT USER_ID,
       PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID,
         PRODUCT_ID
HAVING COUNT(PRODUCT_ID) > 1
ORDER BY USER_ID ASC,
         PRODUCT_ID DESC;