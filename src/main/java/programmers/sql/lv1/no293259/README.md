# LV 1. 잡은 물고기의 평균 길이 구하기 (No. 293259)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/293259)

## 문제 설명

낚시앱에서 사용하는 `FISH_INFO` 테이블은 잡은 물고기들의 정보를 담고 있습니다. `FISH_INFO` 테이블의 구조는 다음과 같으며 `ID`, `FISH_TYPE`, `LENGTH`, `TIME` 은 각각 잡은 물고기의 ID, 물고기의 종류 (숫자), 잡은 물고기의 길이 (cm), 물고기를 잡은 날짜를 나타냅니다.

| Column name | Type | Nullable |
|---|---|---|
| ID | INTEGER | FALSE |
| FISH_TYPE | INTEGER | FALSE |
| LENGTH | FLOAT | TRUE |
| TIME | DATE | FALSE |

단, 잡은 물고기의 길이가 10cm 이하일 경우에는 `LENGTH` 가 NULL 이며, `LENGTH` 에 NULL 만 있는 경우는 없습니다.

## 문제

잡은 물고기의 평균 길이를 출력하는 SQL문을 작성해주세요.

평균 길이를 나타내는 컬럼 명은 `AVERAGE_LENGTH`로 해주세요.

평균 길이는 소수점 3째자리에서 반올림하며, 10cm 이하의 물고기들은 10cm 로 취급하여 평균 길이를 구해주세요.

## 예시

예를 들어 `FISH_INFO` 테이블이 다음과 같다면

| ID | FISH_TYPE | LENGTH | TIME |
|---|---|---|---|
| 0 | 0 | 30 | 2021/12/04 |
| 1 | 0 | 50 | 2020/03/07 |
| 2 | 0 | 40 | 2020/03/07 |
| 3 | 1 | 20 | 2022/03/09 |
| 4 | 1 | NULL | 2022/04/08 |
| 5 | 2 | NULL | 2021/04/28 |

10cm 이하의 물고기는 10cm 로 취급하므로 총 물고기의 길이의 합은 30 + 50 + 40 + 20 + 10 +10 = 160 이며 총 물고기의 수는 6마리이므로 잡은 물고기의 평균 길이는 160/6 = 26.666.. 입니다. 이를 소수점 3째자리에서 반올림하면 26.67 이므로 결과는 다음과 같아야 합니다.

| AVERAGE_LENGTH |
|---|
| 26.67 |

## 풀이

```sql
SELECT 
    ROUND(
        AVG(IFNULL(LENGTH, 10)),
        2
    ) AVERAGE_LENGTH
FROM FISH_INFO;
```

- **`NULL` 관련 함수**

    | 함수 | 의미 | 예시 | 비고 |
    |---|---|---|---|
    | `IFNULL(A, B)` | `A`가 `NULL`이면 `B` 반환 | `IFNULL(LENGTH, 10)` | `NULL`을 다른 값으로 변경 |
    | `NULLIF(A, B)` | `A`와 `B`가 같으면 `NULL` 반환 | `NULLIF(LENGTH, 10)` | 특정 값을 `NULL`로 변경 |
    | `COALESCE(A, B, ...)` | 좌측부터 확인하여 처음으로 `NULL`이 아닌 값 반환 | `COALESCE(LENGTH, 10)` | 두 값만 사용하는 경우 `IFNULL`과 대체 가능 |

- **반올림 관련 함수**

    | 기능 | 함수 | 설명 | 예시 | 결과 예시 |
    |---|---|---|---|---|
    | 반올림 | `ROUND(값, 자릿수)` | 지정한 자릿수까지 반올림 | `ROUND(123.456, 2)` | `123.46` |
    | 소수점 버림 | `TRUNCATE(값, 자릿수)` | 지정한 자릿수 아래를 버림 | `TRUNCATE(123.456, 2)` | `123.45` |
    | 올림 | `CEIL(값)` | 값보다 크거나 같은 가장 작은 정수 | `CEIL(123.1)` | `124` |
    | 올림 | `CEILING(값)` | `CEIL()`과 동일 | `CEILING(123.1)` | `124` |
    | 내림 | `FLOOR(값)` | 값보다 작거나 같은 가장 큰 정수 | `FLOOR(123.9)` | `123` |
    | 절댓값 | `ABS(값)` | 음수/양수를 절댓값으로 변환 | `ABS(-10)` | `10` |
    | 나머지 | `MOD(A, B)` | `A`를 `B`로 나눈 나머지 | `MOD(10, 3)` | `1` |
    | 거듭제곱 | `POWER(A, B)` | `A`의 `B`제곱 | `POWER(2, 3)` | `8` |
    | 제곱근 | `SQRT(값)` | 값의 제곱근 | `SQRT(16)` | `4` |

## 다른 풀이

```sql
SELECT 
    ROUND(
        AVG(COALESCE(LENGTH, 10)),
        2
    ) AS AVERAGE_LENGTH
FROM FISH_INFO;
```

```sql
SELECT 
    ROUND(
        AVG(
            CASE 
                WHEN LENGTH IS NULL THEN 10
                ELSE LENGTH
            END
        ),
        2
    ) AS AVERAGE_LENGTH
FROM FISH_INFO;
```