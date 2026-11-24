# Lv 1. 잔챙이 잡은 수 구하기 (No. 293258)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/293258)

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

잡은 물고기 중 길이가 10cm 이하인 물고기의 수를 출력하는 SQL 문을 작성해주세요.

물고기의 수를 나타내는 컬럼 명은 `FISH_COUNT`로 해주세요.

## 예시

예를 들어 `FISH_INFO` 테이블이 다음과 같다면

| ID | FISH_TYPE | LENGTH | TIME |
|---|---|---|---|
| 0 | 0 | 13.37 | 2021/12/04 |
| 1 | 0 | 50 | 2020/03/07 |
| 2 | 0 | 40 | 2020/03/07 |
| 3 | 1 | 43.33 | 2022/03/09 |
| 4 | 1 | NULL | 2022/04/08 |
| 5 | 2 | NULL | 2020/04/28 |

물고기 ID가 4, 5인 물고기들의 길이가 NULL, 즉 10cm 이하이므로 총 2마리 입니다. 따라서 결과는 다음과 같습니다.

| FISH_COUNT |
|---|
| 2 |

## 풀이

```sql
SELECT COUNT(*) FISH_COUNT
FROM FISH_INFO
WHERE LENGTH IS NULL;
```

| 표현 | 의미 | NULL 처리 |
|---|---|---|
| `COUNT(*)` | 전체 행의 개수를 셈 | NULL 여부와 관계없이 모든 행을 셈 |
| `COUNT(컬럼/표현식)` | 해당 컬럼에 값이 있는 행의 개수를 셈 | NULL은 제외하고 셈 |

## 다른 풀이

```sql
SELECT COUNT(
    CASE WHEN LENGTH IS NULL THEN 1 
    ELSE NULL
END
) AS FISH_COUNT
FROM FISH_INFO;
```
- `CASE WHEN`
    - 기본 구조
        
        ```sql
        CASE
            WHEN 조건 THEN 결과1
            ELSE 결과2
        END
        ```
        
        `ELSE 결과2`는 생략 가능하며, 생략 시 아래(`ELSE NULL`)와 같음
        
        ```sql
        CASE
            WHEN 조건 THEN 결과1
            ELSE NULL
        END
        ```

- `COUNT(컬럼/표현식)`은 `NULL`이 아닌 값의 개수를 세므로, `LENGTH IS NULL`의 경우 `NULL`이 아닌 값인 `1`을 반환하도록 하여 해당 행만 셈
- `COUNT(컬럼/표현식)`에서 반환은 값 자체보다 `NULL` 여부가 중요하므로 반드시 `1`일 필요는 없음

    ```sql
    COUNT(CASE WHEN LENGTH IS NULL THEN 1 END)
    COUNT(CASE WHEN LENGTH IS NULL THEN 100 END)
    COUNT(CASE WHEN LENGTH IS NULL THEN 'A' END)
    ```

    따라서 위처럼 `1`이 아닌 다른 값을 사용하여도 결과는 동일함. 보통 `1`을 사용하는 이유는 조건을 만족한 행을 `COOUNT` 대상에 포함시키는 표시값으로써 가장 간단하기 때문
