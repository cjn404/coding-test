/*
📌 No27. 진료과별 총 예약 횟수 출력하기 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/132202

📝 문제 설명:
다음은 종합병원의 진료 예약정보를 담은 APPOINTMENT 테이블 입니다.
APPOINTMENT 테이블은 다음과 같으며 APNT_YMD, APNT_NO, PT_NO, MCDP_CD, MDDR_ID, APNT_CNCL_YN, APNT_CNCL_YMD는 각각 진료예약일시, 진료예약번호, 환자번호, 진료과코드, 의사ID, 예약취소여부, 예약취소날짜를 나타냅니다.
APPOINTMENT 테이블에서 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회하는 SQL문을 작성해주세요. 이때, 컬럼명은 '진료과 코드', '5월예약건수'로 지정해주시고 결과는 진료과별 예약한 환자 수를 기준으로 오름차순 정렬하고, 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬해주세요.
*/

-- 1. 인덱스 사용 - 시간복잡도 O(log n)
SELECT MCDP_CD  AS "진료과코드",
       COUNT(*) AS "5월예약건수"
FROM APPOINTMENT
WHERE APNT_YMD BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY MCDP_CD
ORDER BY COUNT(*), MCDP_CD;

-- 2. 숫자 비교 - 시간복잡도 O(n)
SELECT MCDP_CD  AS "진료과코드",
       COUNT(*) AS "5월예약건수"
FROM APPOINTMENT
WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 5
GROUP BY MCDP_CD
ORDER BY COUNT(*), MCDP_CD;

-- 3. 문자열 비교 - 시간복잡도 O(n)
SELECT MCDP_CD  AS "진료과코드",
       COUNT(*) AS "5월예약건수"
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m') = '2022-05'
GROUP BY MCDP_CD
ORDER BY COUNT(*), MCDP_CD;