/*
📌 No14. 가장 비싼 상품 구하기 (답안 2가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131697

📝 문제 설명:
다음은 어느 의류 쇼핑몰에서 판매 중인 상품들의 정보를 담은 PRODUCT 테이블입니다. PRODUCT 테이블은 아래와 같은 구조로 되어있으며, PRODUCT_ID, PRODUCT_CODE, PRICE는 각각 상품 ID, 상품코드, 판매가를 나타냅니다.
상품 별로 중복되지 않는 8자리 상품코드 값을 가지며, 앞 2자리는 카테고리 코드를 의미합니다.
PRODUCT 테이블에서 판매 중인 상품 중 가장 높은 판매가를 출력하는 SQL문을 작성해주세요. 이때 컬럼명은 MAX_PRICE로 지정해주세요.
*/

-- 1. 정렬 + LIMIT 사용
SELECT PRICE AS MAX_PRICE
FROM PRODUCT
ORDER BY PRICE DESC LIMIT 1;

-- 2. MAX 함수 사용
SELECT MAX(PRICE) AS MAX_PRICE
FROM PRODUCT;