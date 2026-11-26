# Lv 1. 잡은 물고기 중 가장 큰 물고기의 길이 구하기 (No. 298515)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/298515)

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

`FISH_INFO` 테이블에서 잡은 물고기 중 가장 큰 물고기의 길이를 'cm' 를 붙여 출력하는 SQL 문을 작성해주세요.

이 때 컬럼명은 `MAX_LENGTH` 로 지정해주세요.

## 예시

예를 들어 `FISH_INFO` 테이블이 다음과 같다면

| ID | FISH_TYPE | LENGTH | TIME |
|---|---|---|---|
| 0 | 0 | 13.37 | 2021/12/04 |
| 1 | 0 | 50.00 | 2020/03/07 |
| 2 | 0 | 40.00 | 2020/03/07 |
| 3 | 1 | 43.33 | 2022/03/09 |
| 4 | 1 | NULL | 2022/04/08 |
| 5 | 2 | 32.00 | 2020/04/28 |

가장 큰 물고기의 길이는 50cm 이므로 결과는 다음과 같아야 합니다.

| MAX_LENGTH |
|---|
| 50.00cm |

## 풀이

```sql
SELECT
    CONCAT(
        MAX(LENGTH),
        'cm'
    ) MAX_LENGTH
FROM FISH_INFO;
```

- **집계 함수**

    | 함수 | 의미 | 예시 | 설명 |
    |---|---|---|---|
    | `MAX()` | 최댓값 | `MAX(LENGTH)` | 컬럼에서 가장 큰 값을 반환 |
    | `MIN()` | 최솟값 | `MIN(LENGTH)` | 컬럼에서 가장 작은 값을 반환 |
    | `SUM()` | 합계 | `SUM(PRICE)` | 컬럼 값의 총합을 반환 |
    | `AVG()` | 평균 | `AVG(PRICE)` | 컬럼 값의 평균을 반환 |
    | `COUNT(*)` | 전체 행 개수 | `COUNT(*)` | `NULL` 여부와 관계없이 전체 행 개수를 반환 |
    | `COUNT(컬럼)` | 값의 개수 | `COUNT(LENGTH)` | 해당 컬럼에서 `NULL`을 제외한 값의 개수를 반환 |

- **문자열 연결 함수**

    | 함수 | 의미 | 사용법 | 예시 | 결과 |
    |---|---|---|---|---|
    | `CONCAT()` | 문자열 연결 | `CONCAT(값1, 값2, ...)` | `CONCAT(50, 'cm')` | `50cm` |
    | `CONCAT_WS()` | 구분자를 넣어 문자열 연결 | `CONCAT_WS(구분자, 값1, 값2, ...)` | `CONCAT_WS('-', '2026', '11', '26')` | `2026-11-26` |

## 다른 풀이

```sql
SELECT
    CONCAT(LENGTH, 'cm') AS MAX_LENGTH
FROM FISH_INFO
ORDER BY LENGTH DESC
LIMIT 1;
```