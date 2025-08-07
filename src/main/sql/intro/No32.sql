/*
📌 No32. 카테고리 별 도서 판매량 집계하기
문제 링크:
https://school.programmers.co.kr/learn/courses/30/lessons/144855

📝 문제 설명:
다음은 어느 한 서점에서 판매중인 도서들의 도서 정보(BOOK), 판매 정보(BOOK_SALES) 테이블입니다.
BOOK 테이블은 각 도서의 정보를 담은 테이블로 아래와 같은 구조로 되어있습니다.
BOOK_SALES 테이블은 각 도서의 날짜 별 판매량 정보를 담은 테이블로 아래와 같은 구조로 되어있습니다.
2022년 1월의 카테고리 별 도서 판매량을 합산하고, 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력하는 SQL문을 작성해주세요.
결과는 카테고리명을 기준으로 오름차순 정렬해주세요.
*/

-- 1. 인덱스 사용 O
SELECT B.CATEGORY,
       SUM(S.SALES) AS TOTAL_SALES
FROM BOOK B
         INNER JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
WHERE S.SALES_DATE BETWEEN DATE '2022-01-01' AND DATE '2022-01-31'
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY;

-- 2. 인덱스 사용 X -> 테이블 전체 스캔
SELECT B.CATEGORY,
       SUM(S.SALES) AS TOTAL_SALES
FROM BOOK B
         INNER JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
WHERE DATE_FORMAT(S.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY;

-- 3. 인덱스 사용 X -> 테이블 전체 스캔
SELECT B.CATEGORY,
       SUM(S.SALES) AS TOTAL_SALES
FROM BOOK B
         INNER JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
WHERE YEAR(S.SALES_DATE) = 2022 AND MONTH(S.SALES_DATE) = 1
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY;

