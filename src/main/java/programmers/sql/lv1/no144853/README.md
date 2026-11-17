# Lv 1. 조건에 맞는 도서 리스트 출력하기 (No. 144853)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/144853)

## 문제 설명

다음은 어느 한 서점에서 판매중인 도서들의 도서 정보 (`BOOK`) 테이블입니다.

`BOOK` 테이블은 각 도서의 정보를 담은 테이블로 아래와 같은 구조로 되어있습니다.

| Column name | Type | Nullable | Description |
|---|---|---|---|
| BOOK_ID | INTEGER | FALSE | 도서 ID |
| CATEGORY | VARCHAR (N) | FALSE | 카테고리 (경제, 인문, 소설, 생활, 기술) |
| AUTHOR_ID | INTEGER | FALSE | 저자 ID |
| PRICE | INTEGER | FALSE | 판매가 (원) |
| PUBLISHED_DATE | DATE | FALSE | 출판일 |

## 문제

`BOOK` 테이블에서 2021년에 출판된 '인문' 카테고리에 속하는 도서 리스트를 찾아서 도서 ID (`BOOK_ID`), 출판일 (`PUBLISHED_DATE`)을 출력하는 SQL문을 작성해주세요.

결과는 출판일을 기준으로 오름차순 정렬해주세요.

## 예시

예를 들어 `BOOK` 테이블이 다음과 같다면

| BOOK_ID | CATEGORY | AUTHOR_ID | PRICE | PUBLISHED_DATE |
|---|---|---|---|---|
| 1 | 인문 | 1 | 10000 | 2020-01-01 |
| 2 | 경제 | 2 | 9000 | 2021-02-05 |
| 3 | 인문 | 2 | 11000 | 2021-04-11 |
| 4 | 인문 | 3 | 10000 | 2021-03-15 |
| 5 | 생활 | 1 | 12000 | 2021-01-10 |

조건에 속하는 도서는 도서 ID가 3, 4인 도서이므로 다음과 같습니다.

| BOOK_ID | PUBLISHED_DATE |
|---|---|
| 3 | 2021-04-11 |
| 4 | 2021-03-15 |

그리고 출판일 오름차순으로 정렬하여야 하므로 다음과 같은 결과가 나와야 합니다.

| BOOK_ID | PUBLISHED_DATE |
|---|---|
| 4 | 2021-03-15 |
| 3 | 2021-04-11 |

## 주의사항

`PUBLISHED_DATE`의 데이트 포맷이 예시와 동일해야 정답처리 됩니다.

## 풀이

```sql
SELECT BOOK_ID, 
       DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') PUBLISHED_DATE
FROM BOOK
WHERE PUBLISHED_DATE >= '2021-01-01' 
    AND PUBLISHED_DATE < '2022-01-01' 
    AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE;
```

- 2021-01-01 이상, 2022-01-01 미만으로 2021년 전체 범위를 조회
- 위 문제에서 `PUBLISHED_DATE`는 `DATE` 타입이나, 특히 `DATETIME`인 경우 시간값이 포함될 수 있으므로 종료일을 `< 2022-01-01`로 지정하는 것이 안전

- **`DATE_FORMAT()` 주요 형식**

    | 형식 | 의미 | 예시 |
    |---|---|---|
    | `%Y` | 4자리 연도 | `2021` |
    | `%y` | 2자리 연도 | `21` |
    | `%m` | 2자리 월 | `04` |
    | `%c` | 숫자 월 | `4` |
    | `%d` | 2자리 일 | `11` |
    | `%e` | 숫자 일 | `11` |
    | `%H` | 24시간 형식 시간 | `13` |
    | `%i` | 분 | `30` |
    | `%s` | 초 | `25` |

## 다른 풀이

```sql
SELECT BOOK_ID, 
       DATE(PUBLISHED_DATE) AS PUBLISHED_DATE
FROM BOOK
WHERE PUBLISHED_DATE BETWEEN '2021-01-01' AND '2021-12-31' 
    AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE ASC;
```

- `>= '2021-01-01' AND <= '2021-12-31'`과 동일한 의미로, 양쪽 값을 모두 포함
    - `AND`는 조건을 연결하는 논리 연산자가 아닌 `BETWEEN` 문법의 일부(`BETWEEN A AND B`)

```sql
SELECT BOOK_ID, 
       DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK
WHERE YEAR(PUBLISHED_DATE) = 2021
    AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE ASC;
```

- `YEAR()`로 출판일의 연도만 추출하여 2021년 데이터 조회
    - 컬럼에 함수 적용 시 인덱스 활용에 불리할 수 있음

- **날짜 관련 추출 함수**

    | 함수 | 설명 | 예시 | 결과 |
    |---|---|---|---|
    | `DATE(date)` | 날짜/시간에서 날짜 부분만 추출 | `DATE('2021-04-11 13:30:25')` | `2021-04-11` |
    | `YEAR(date)` | 연도 추출 | `YEAR('2021-04-11')` | `2021` |
    | `MONTH(date)` | 월 추출 | `MONTH('2021-04-11')` | `4` |
    | `DAY(date)` | 일 추출 | `DAY('2021-04-11')` | `11` |
    | `DAYOFMONTH(date)` | 일을 추출 (`DAY()`와 동일) | `DAYOFMONTH('2021-04-11')` | `11` |
    | `HOUR(time)` | 시간 추출 | `HOUR('13:30:25')` | `13` |
    | `MINUTE(time)` | 분 추출 | `MINUTE('13:30:25')` | `30` |
    | `SECOND(time)` | 초 추출 | `SECOND('13:30:25')` | `25` |
    | `TIME(datetime)` | 날짜/시간에서 시간 부분만 추출 | `TIME('2021-04-11 13:30:25')` | `13:30:25` |
    | `DAYOFWEEK(date)` | 요일을 숫자로 반환 (일요일=1 ~ 토요일=7) | `DAYOFWEEK('2021-04-11')` | `1` |
    | `WEEKDAY(date)` | 요일을 숫자로 반환 (월요일=0 ~ 일요일=6) | `WEEKDAY('2021-04-11')` | `6` |
    | `WEEK(date)` | 해당 날짜의 주(week) 번호 반환 | `WEEK('2021-04-11')` | 주 번호 |
    | `QUARTER(date)` | 분기 추출 (1~4) | `QUARTER('2021-04-11')` | `2` |   

- `DATE()` vs `DATE_FORMAT()`: 목적이 다름

    | 구분 | `DATE()` | `DATE_FORMAT()` |
    |---|---|---|
    | 목적 | 날짜 부분 **추출** | 날짜의 **출력 형식 지정** |
    | 문법 | `DATE(date)` | `DATE_FORMAT(date, format)` |
    | 주 사용 대상 | `DATETIME`, `TIMESTAMP` 등 | `DATE`, `DATETIME` 등 |
    | 예시 | `DATE('2021-04-11 13:30:25')` | `DATE_FORMAT('2021-04-11', '%Y-%m-%d')` |
    | 결과 | `2021-04-11` | `2021-04-11` |
    | 반환 의미 | 날짜 값 | 지정된 형식의 문자열 |
    | 핵심 | 시간 부분을 제거하고 날짜만 가져옴 | 날짜를 원하는 모양으로 표현 |