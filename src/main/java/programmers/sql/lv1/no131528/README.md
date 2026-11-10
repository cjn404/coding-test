# Lv 1. 나이 정보가 없는 회원 수 구하기 (No. 131528)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/131528)

## 문제 설명

다음은 어느 의류 쇼핑몰에 가입한 회원 정보를 담은 `USER_INFO` 테이블입니다. `USER_INFO` 테이블은 아래와 같은 구조로 되어있으며, `USER_ID`, `GENDER`, `AGE`, `JOINED` 는 각각 회원 ID, 성별, 나이, 가입일을 나타냅니다.

| Column name | Type | Nullable |
|---|---|---|
| USER_ID | INTEGER | FALSE |
| GENDER | TINYINT (1) | TRUE |
| AGE | INTEGER | TRUE |
| JOINED | DATE | FALSE |

`GENDER` 컬럼은 비어있거나 0 또는 1의 값을 가지며 0인 경우 남자를, 1인 경우는 여자를 나타냅니다.

## 문제

`USER_INFO` 테이블에서 나이 정보가 없는 회원이 몇 명인지 출력하는 SQL문을 작성해주세요. 이때 컬럼명은 `USERS`로 지정해주세요.

## 예시

예를 들어 `USER_INFO` 테이블이 다음과 같다면

| USER_ID | GENDER | AGE | JOINED |
|---|---|---|---|
| 1 | 1 | 26 | 2021-06-01 |
| 2 | NULL | NULL | 2021-07-25 |
| 3 | 1 | NULL | 2021-07-30 |
| 4 | 0 | 31 | 2021-08-03 |

나이 정보가 없는 회원은 2명 이므로, 다음과 같은 결과가 나와야 합니다.

| USERS |
|---|
| 2 |

## 풀이

```sql
SELECT COUNT(*) USERS
FROM USER_INFO
WHERE AGE IS NULL
```
- `AS`: 생략 가능
- `NULL`은 일반 값이 아닌 알 수 없는 값(Unknown)을 의미. 따라서 `NULL` 여부 확인 시 일반 값처럼 일반 비교 연산자로 비교할 수 없으며, 별도의 문법 제공함
    
    ```sql
    컬럼명 IS NULL      -- 해당 컬럼의 값이 NULL인지 확인
    컬럼명 IS NOT NULL  -- 해당 컬럼의 값이 NULL이 아닌지 확인
    ```

- **결론**

    | 조건 | 올바른 표현 |
    |---|---|
    | NULL이다 | `IS NULL` |
    | NULL이 아니다 | `IS NOT NULL` |
    | 값이 같다 | `=` |
    | 값이 다르다 | `<>` 또는 `!=` |
    | 문자열 패턴 비교 | `LIKE` |

## 다른 풀이

```sql
-- MySQL
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE ISNULL(AGE)
```
- `ISNULL(컬럼명)`은 DBMS마다 지원 여부나 사용 방식이 다를 수 있으므로, 일반적으로 `컬럼명 IS NULL`을 사용하는 것이 보편적