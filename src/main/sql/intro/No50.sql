/*
📌 No50. 5월 식품들의 총매출 조회하기(답안 4가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131117

📝 문제 설명:
FOOD_PRODUCT와 FOOD_ORDER 테이블에서 생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성해주세요. 이때 결과는 총매출을 기준으로 내림차순 정렬해주시고 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬해주세요.
*/

SELECT P.PRODUCT_ID,
       P.PRODUCT_NAME,
       SUM(O.AMOUNT * P.PRICE) TOTAL_SALES
FROM FOOD_PRODUCT P
         JOIN FOOD_ORDER O
              ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE O.PRODUCE_DATE >= '2022-05-01'
  AND O.PRODUCE_DATE < '2022-06-01'
GROUP BY P.PRODUCT_ID,
         P.PRODUCT_NAME
ORDER BY TOTAL_SALES DESC,
         P.PRODUCT_ID;

SELECT P.PRODUCT_ID,
       P.PRODUCT_NAME,
       SUM(O.AMOUNT * P.PRICE) TOTAL_SALES
FROM FOOD_PRODUCT P
         JOIN FOOD_ORDER O
              ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE O.PRODUCE_DATE
          BETWEEN '2022-05-01'
          AND '2022-05-31'
GROUP BY P.PRODUCT_ID,
         P.PRODUCT_NAME
ORDER BY TOTAL_SALES DESC,
         P.PRODUCT_ID;

SELECT P.PRODUCT_ID,
       P.PRODUCT_NAME,
       SUM(O.AMOUNT * P.PRICE) TOTAL_SALES
FROM FOOD_PRODUCT P
         JOIN FOOD_ORDER O
              ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE O.PRODUCE_DATE LIKE '2022-05-%'
GROUP BY P.PRODUCT_ID,
         P.PRODUCT_NAME
ORDER BY TOTAL_SALES DESC,
         P.PRODUCT_ID;

SELECT P.PRODUCT_ID,
       P.PRODUCT_NAME,
       SUM(O.AMOUNT * P.PRICE) TOTAL_SALES
FROM FOOD_PRODUCT P
         JOIN FOOD_ORDER O
              ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE DATE_FORMAT(O.PRODUCE_DATE, '%Y-%m') = '2022-05'
GROUP BY P.PRODUCT_ID,
         P.PRODUCT_NAME
ORDER BY TOTAL_SALES DESC,
         P.PRODUCT_ID;