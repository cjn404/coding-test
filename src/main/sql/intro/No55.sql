/*
📌 No55. 조건에 맞는 사용자 정보 조회하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/164670

📝 문제 설명:
USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서 중고 거래 게시물을 3건 이상 등록한 사용자의 사용자 ID, 닉네임, 전체주소, 전화번호를 조회하는 SQL문을 작성해주세요. 이때, 전체 주소는 시, 도로명 주소, 상세 주소가 함께 출력되도록 해주시고, 전화번호의 경우 xxx-xxxx-xxxx 같은 형태로 하이픈 문자열(-)을 삽입하여 출력해주세요. 결과는 회원 ID를 기준으로 내림차순 정렬해주세요.
*/

SELECT U.USER_ID,
       U.NICKNAME,
       CONCAT(U.CITY, ' ',
              U.STREET_ADDRESS1, ' ',
              U.STREET_ADDRESS2)
           전체주소,
       CONCAT(SUBSTRING(U.TLNO, 1, 3), '-',
              SUBSTRING(U.TLNO, 4, 4), '-',
              SUBSTRING(U.TLNO, 8))
           전화번호
FROM USED_GOODS_BOARD B
         JOIN USED_GOODS_USER U
              ON B.WRITER_ID = U.USER_ID
GROUP BY U.USER_ID,
         U.NICKNAME,
         U.CITY,
         U.STREET_ADDRESS1,
         U.STREET_ADDRESS2,
         U.TLNO
HAVING COUNT(B.WRITER_ID) >= 3
ORDER BY U.USER_ID DESC;