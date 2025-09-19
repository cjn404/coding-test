/*
📌 No49. 식품분류별 가장 비싼 식품의 정보 조회하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131116

📝 문제 설명:
FOOD_PRODUCT 테이블에서 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회하는 SQL문을 작성해주세요. 이때 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력시켜 주시고 결과는 식품 가격을 기준으로 내림차순 정렬해주세요.
*/

SELECT F.CATEGORY,
       F.PRICE,
       F.PRODUCT_NAME
FROM FOOD_PRODUCT F
         JOIN (SELECT CATEGORY,
                      MAX(PRICE) MAX_PRICE
               FROM FOOD_PRODUCT
               WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
               GROUP BY CATEGORY) M
              ON F.CATEGORY = M.CATEGORY AND F.PRICE = M.MAX_PRICE
ORDER BY F.PRICE DESC;