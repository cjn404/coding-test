# Lv. 1 경기도에 위치한 식품창고 목록 출력하기(No. 131114)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/131114)

## 문제 설명
다음은 식품창고의 정보를 담은 `FOOD_WAREHOUSE` 테이블입니다. `FOOD_WAREHOUSE` 테이블은 다음과 같으며 `WAREHOUSE_ID`, `WAREHOUSE_NAME`, `ADDRESS`, `TLNO`, `FREEZER_YN`는 창고 ID, 창고 이름, 창고 주소, 전화번호, 냉동시설 여부를 의미합니다.

| Column name | Type | Nullable |
|---|---|---|
| WAREHOUSE_ID | VARCHAR(10) | FALSE |
| WAREHOUSE_NAME | VARCHAR(20) | FALSE |
| ADDRESS | VARCHAR(100) | TRUE |
| TLNO | VARCHAR(20) | TRUE |
| FREEZER_YN | VARCHAR(1) | TRUE |

## 문제
`FOOD_WAREHOUSE` 테이블에서 경기도에 위치한 창고의 ID, 이름, 주소, 냉동시설 여부를 조회하는 SQL문을 작성해주세요. 이때 냉동시설 여부가 NULL인 경우, 'N'으로 출력시켜 주시고 결과는 창고 ID를 기준으로 오름차순 정렬해주세요.

## 예시
`FOOD_WAREHOUSE` 테이블이 다음과 같을 때

| WAREHOUSE_ID | WAREHOUSE_NAME | ADDRESS | TLNO | FREEZER_YN |
|---|---|---|---|---|
| WH0001 | 창고_경기1 | 경기도 안산시 상록구 용담로 141 | 031-152-1332 | Y |
| WH0002 | 창고_충북1 | 충청북도 진천군 진천읍 씨제이로 110 | 043-623-9900 | Y |
| WH0003 | 창고_경기2 | 경기도 이천시 마장면 덕평로 811 | 031-221-7241 | NULL |
| WH0004 | 창고_경기3 | 경기도 김포시 대곶면 율생중앙로205번길 | 031-671-1900 | N |
| WH0005 | 창고_충남1 | 충청남도 천안시 동남구 광덕면 신덕리1길 9 | 041-876-5421 | Y |

SQL을 실행하면 다음과 같이 출력되어야 합니다.

| WAREHOUSE_ID | WAREHOUSE_NAME | ADDRESS | FREEZER_YN |
|---|---|---|---|
| WH0001 | 창고_경기1 | 경기도 안산시 상록구 용담로 141 | Y |
| WH0003 | 창고_경기2 | 경기도 이천시 마장면 덕평로 811 | N |
| WH0004 | 창고_경기3 | 경기도 김포시 대곶면 율생중앙로205번길 | N |

## 풀이
### `LIKE`와 `%`
- `LIKE`: 문자열 특정 패턴 검색
- `%`: 0개 이상의 임의의 문자. 위치에 따라 검색 조건 상이

| 사용법 | 의미 | 예시 |
|---|---|---|
| `LIKE '경기도%'` | `경기도`로 시작 | 경기도 평택시 |
| `LIKE '%경기도'` | `경기도`로 끝남 | 대한민국 경기도 |
| `LIKE '%경기도%'` | `경기도`가 포함됨 | 대한민국 경기도 평택시 |

### NULL 처리
- 표준 SQL 함수: `COALESCE(값 1, 값 2, ...)`
  - 좌측부터 확인하여 처음으로 NULL이 아닌 값 반환
    - 예시:

      | MOBILE_PHONE | HOME_PHONE | OFFICE_PHONE |
      |---|---|---|
      | 010-1234-5678 | NULL | 02-123-4567 |
      | NULL | 031-123-4567 | 02-234-5678 |
      | NULL | NULL | 02-345-6789 |
      `COALESCE(MOBILE_PHONE, HOME_PHONE)`
      - 결과: 
        ```
        010-1234-5678
        031-123-4567
        NULL
        ```
  - `COALESCE(컬럼명, 대체값)`으로 사용 시 컬럼값이 NULL이면 지정한 대체값 출력, NULL이 아니면 기존 값 반환

### 다른 풀이
```sql
-- 방법 1: MySQL - IFNULL
SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       IFNULL(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID ASC;
```
- MySQL 전용 함수: `IFNULL(컬럼명, 대체값)`
  - 컬럼값이 NULL이면 지정한 대체값 출력, NULL이 아니면 기존 값 반환

```sql
-- 방법 2: MSSQL - ISNULL
SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       ISNULL(FREEZER_YN, 'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID ASC;
```
- MSSQL 전용 함수: `ISNULL(컬럼명, 대체값)`
  - 컬럼값이 NULL이면 지정한 대체값 반환, NULL이 아니면 기존 값 반환

```sql
-- 방법 3: CASE WHEN
SELECT WAREHOUSE_ID,
       WAREHOUSE_NAME,
       ADDRESS,
       CASE
           WHEN FREEZER_YN IS NULL THEN 'N'
           ELSE FREEZER_YN
       END AS FREEZER_YN
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID ASC; 
```
```sql
-- 프로그래밍의 if-else
CASE
    WHEN 조건 THEN 조건이 참일 때 값
    ELSE 조건이 거짓일 때 값
END
```
- 복잡한 처리 조건 가능
- `IS NULL`: NULL인지 확인
- `IS NOT NULL`: NULL이 아닌지 확인
- `END` 이후 `AS`: 결과 컬럼의 별칭(alias)을 지정하며 생략 가능
