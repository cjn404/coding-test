# Lv 1. 자동차 대여 기록에서 장기/단기 대여 구분하기 (No. 151138)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/151138)

## 문제 설명

다음은 어느 자동차 대여 회사의 자동차 대여 기록 정보를 담은 `CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블입니다. `CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블은 아래와 같은 구조로 되어있으며, `HISTORY_ID`, `CAR_ID`, `START_DATE`, `END_DATE` 는 각각 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일을 나타냅니다.

| Column name | Type | Nullable |
|---|---|---|
| HISTORY_ID | INTEGER | FALSE |
| CAR_ID | INTEGER | FALSE |
| START_DATE | DATE | FALSE |
| END_DATE | DATE | FALSE |

## 문제

`CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블에서 대여 시작일이 2022년 9월에 속하는 대여 기록에 대해서 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 표시하는 컬럼 (컬럼명: `RENT_TYPE`)을 추가하여 대여기록을 출력하는 SQL문을 작성해주세요. 결과는 대여 기록 ID를 기준으로 내림차순 정렬해주세요.

## 예시

예를 들어 `CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블이 다음과 같다면

| HISTORY_ID | CAR_ID | START_DATE | END_DATE |
|---|---|---|---|
| 1 | 4 | 2022-09-27 | 2022-11-27 |
| 2 | 3 | 2022-10-03 | 2022-11-04 |
| 3 | 2 | 2022-09-05 | 2022-09-05 |
| 4 | 1 | 2022-09-01 | 2022-09-30 |
| 5 | 3 | 2022-09-16 | 2022-10-15 |

2022년 9월의 대여 기록 중 '장기 대여' 에 해당하는 기록은 대여 기록 ID가 1, 4인 기록이고, '단기 대여' 에 해당하는 기록은 대여 기록 ID가 3, 5 인 기록이므로 대여 기록 ID를 기준으로 내림차순 정렬하면 다음과 같이 나와야 합니다.

| HISTORY_ID | CAR_ID | START_DATE | END_DATE | RENT_TYPE |
|---|---|---|---|---|
| 5 | 3 | 2022-09-16 | 2022-10-13 | 단기 대여 |
| 4 | 1 | 2022-09-01 | 2022-09-30 | 장기 대여 |
| 3 | 2 | 2022-09-05 | 2022-09-05 | 단기 대여 |
| 1 | 4 | 2022-09-27 | 2022-10-26 | 장기 대여 |

## 주의사항

`START_DATE` 와 `END_DATE` 의 경우 예시의 데이트 포맷과 동일해야 정답처리 됩니다.

## 풀이

```sql
SELECT HISTORY_ID,
       CAR_ID,
       DATE_FORMAT(START_DATE, '%Y-%m-%d') START_DATE,
       DATE_FORMAT(END_DATE, '%Y-%m-%d') END_DATE,
       CASE 
            WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '장기 대여'
            ELSE '단기 대여'
        END RENT_TYPE 
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE >= '2022-09-01'
    AND START_DATE < '2022-10-01'
ORDER BY HISTORY_ID DESC;
```
- `AS`: 생략 무방
- `DATEDIFF(날짜 1, 날짜 2)`: 두 날짜의 일수 차이(`날짜 1` - `날짜 2`) 계산 함수
    - 예를 들어,
        ```sql
        START_DATE = 2022-09-01
        END_DATE   = 2022-09-30
        ```
        를 DATEDIFF()만 하면 `DATEDIFF('2022-09-30', '2022-09-01')` 즉 29일이되므로 `+ 1`을 함
- **`CASE WHEN`**
    - `CASE WHEN`은 조건에 따라 특정 값을 반환하는 표현식
    - 기본 구조:
        ```sql
        CASE
            WHEN 조건1 THEN 값1
            WHEN 조건2 THEN 값2
            ELSE 값3
        END
        ```
    - 사용처 정리

        | 위치 | CASE WHEN 사용 | 주된 역할 |
        |---|---|---|
        | SELECT | O | 조건에 따라 출력값 결정 |
        | WHERE | O | 조건에 따라 조회할 행 필터링 |
        | GROUP BY | O | 조건에 따라 그룹 생성 |
        | HAVING | O | 그룹화된 결과 조건에 따라 필터링 |
        | ORDER BY | O | 조건에 따라 정렬 기준 지정 |
        | FROM | 직접 사용 X | 조회할 테이블 서브쿼리 지정 |

- `DATETIME` 고려가 필요한 경우, `>= 시작일 AND < 다음 기간 시작일` 방식이 더 안전함. 위 문제에서는 `START_DATE`과 `END_DATE` 모두 `DATE` 컬럼으므로 무방함


## 다른 풀이

```sql
SELECT HISTORY_ID,
       CAR_ID,
       DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
       DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
       CASE 
            WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '장기 대여'
            ELSE '단기 대여'
        END AS RENT_TYPE 
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE BETWEEN '2022-09-01' AND '2022-09-30'
ORDER BY HISTORY_ID DESC;
```
- `BETWEEN A AND B`: 양 끝값 모두 포함. 따라서 `컬럼 >= A AND 컬럼 <= 'B'`와 동일한 의미

```sql
SELECT HISTORY_ID,
       CAR_ID,
       DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
       DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
       CASE
           WHEN DATEDIFF(END_DATE, START_DATE) >= 29 THEN '장기 대여'
           ELSE '단기 대여'
       END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, '%Y-%m') = '2022-09'
ORDER BY HISTORY_ID DESC;
```
- 컬럼에 `DATE_FORMAT()`과 같은 함수를 적용하면 인덱스를 효율적으로 사용하지 못할 수 있으므로 `START_DATE >= '2022-09-01' AND START_DATE < '2022-10-01'`처럼 범위 조건 사용 권장