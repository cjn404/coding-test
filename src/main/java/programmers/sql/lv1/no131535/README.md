# Lv 1. 조건에 맞는 회원수 구하기 (No. 131535)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/131535)

## 문제 설명

다음은 어느 의류 쇼핑몰에 가입한 회원 정보를 담은 `USER_INFO` 테이블입니다. `USER_INFO` 테이블은 아래와 같은 구조로 되어있으며 `USER_ID`, `GENDER`, `AGE`, `JOINED` 는 각각 회원 ID, 성별, 나이, 가입일을 나타냅니다.

| Column name | Type | Nullable |
|---|---|---|
| USER_ID | INTEGER | FALSE |
| GENDER | TINYINT (1) | TRUE |
| AGE | INTEGER | TRUE |
| JOINED | DATE | FALSE |

`GENDER` 컬럼은 비어있거나 0 또는 1의 값을 가지며 0인 경우 남자를, 1인 경우는 여자를 나타냅니다.

## 문제

`USER_INFO` 테이블에서 2021년에 가입한 회원 중 나이가 20세 이상 29세 이하인 회원이 몇 명인지 출력하는 SQL문을 작성해주세요.

## 예시

예를 들어 `USER_INFO` 테이블이 다음과 같다면

| USER_ID | GENDER | AGE | JOINED |
|---|---|---|---|
| 1 | 1 | 26 | 2021-10-05 |
| 2 | 0 | NULL | 2021-11-25 |
| 3 | 1 | 22 | 2021-11-30 |
| 4 | 0 | 31 | 2021-12-03 |
| 5 | 0 | 28 | 2021-12-16 |
| 6 | 1 | 24 | 2022-01-03 |
| 7 | 1 | NULL | 2022-01-09 |

2021년에 가입한 회원 중 나이가 20세 이상 29세 이하인 회원은 `USER_ID` 가 1, 3, 5 인 회원들 이므로, 다음과 같이 결과가 나와야 합니다.

| USERS |
|---|
| 3 |

## 풀이

```sql
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE JOINED >= '2021-01-01'
  AND JOINED < '2022-01-01'
  AND AGE >= 20
  AND AGE <= 29;
```
- `<`를 사용하는 패턴은 `DATE` 뿐 아니라 시간이 포함된 `DATETIME`, `TIMESTAMP`에서도 안전함
    - 예를 들어 `JOINED <= '2021-12-31'`은 `DATETIME`이나 `TIMESTAMP`에서 `'2021-12-31 15:30:00'`과 같이 12월 31일에 시간 값이 포함된 데이터를 놓칠 수 있으므로, `JOINED < '2022-01-01'` 형태로 작성하는 것이 안전함
- 또한 만약 `JOINED`가 인덱스가 있는 컬럼이라면 `YEAR()`처럼 컬럼에 함수를 적용하는 방법은 인덱스를 효율적으로 사용하기 어려울 수 있음. 반면 날짜 범위를 직접 비교 시 `JOINED` 자체를 그대로 비교하므로 일반적인 B-tree 인덱스의 range scan을 활용하기 좋음
- **즉 인덱스가 있는 컬럼에 가능하면 함수를 씌우지 않고 원본 컬럼을 범위 비교하는 것이 유리**

    | 데이터 유형 | 작성 예시 | 따옴표 사용 유무 |
    |---|---|---|
    | 숫자 | `YEAR(JOINED) = 2021` | X |
    | 문자열 | `NAME = 'KIM'` | O |
    | 날짜 | `JOINED = '2021-10-05'` | O |

    | 따옴표 | 용도 | 예시 |
    |---|---|---|
    | 작은따옴표 `' '` | 문자열, 날짜 등의 **값** | `'KIM'`, `'2021-10-05'` |
    | 큰따옴표 `" "` | 컬럼명, 테이블명 등의 **식별자** | `SELECT "USER_ID" FROM "USER_INFO"` |

    | 표현 | NULL 포함 유무 | 의미 |
    |---|---|---|
    | `COUNT(*)` | O, NULL 여부와 관계없음 | **모든 행**의 개수를 셈 |
    | `COUNT(컬럼)` | X, NULL 제외 | 해당 컬럼이 **NULL이 아닌 행**만 셈 |
    | `COUNT(DISTINCT 컬럼)` | X, NULL 제외 | NULL 제외 + **중복되지 않은 값**의 개수를 셈 |

## 다른 풀이

```sql
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE JOINED >= '2021-01-01'
  AND JOINED < '2022-01-01'
  AND AGE BETWEEN 20 AND 29;
```
- `BETWEEN`은 양쪽 끝을 포함함. 즉 `20 ≤ AGE ≤ 29`

```sql
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE EXTRACT(YEAR FROM JOINED) = 2021 
    AND AGE BETWEEN 20 AND 29;
```
- `EXTRACT(YEAR FROM 컬럼명)`: 날짜에서 연도만 추출. SQL 표준적인 방식

```sql
SELECT COUNT(*) USERS
FROM USER_INFO
WHERE YEAR(JOINED) = 2021 
    AND AGE BETWEEN 20 AND 29;
```
- `YEAR(JOINED)`: 날짜에서 연도만 추출. MySQL 등에서 지원하는 방식

```sql
SELECT COUNT(*) USERS
FROM USER_INFO
WHERE YEAR(JOINED) = 2021 
    AND AGE >= 20 AND AGE <= 29;
```

⚠️ 비추천
```sql
SELECT COUNT(*) USERS
FROM USER_INFO
WHERE JOINED LIKE '2021%' 
    AND AGE BETWEEN 20 AND 29;
```
- 위 쿼리에서 `JOINED`는 문자열이 아닌 날짜형이고 `LIKE`는 문자열 패턴을 찾는 연산자이므로, `JOINED LIKE '2021%'`라고 하면 DBMS에 따라 내부적으로 날짜를 문자로 변환하여 비교하는 암묵적 형변환에 의존할 수 있음 