# Lv 1. 과일로 만든 아이스크림 고르기 (No. 133025)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/133025)

## 문제 설명

다음은 아이스크림 가게의 상반기 주문 정보를 담은 `FIRST_HALF` 테이블과 아이스크림 성분에 대한 정보를 담은 `ICECREAM_INFO` 테이블입니다. `FIRST_HALF` 테이블 구조는 다음과 같으며, `SHIPMENT_ID`, `FLAVOR`, `TOTAL_ORDER` 는 각각 아이스크림 공장에서 아이스크림 가게까지의 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량을 나타냅니다. `FIRST_HALF` 테이블의 기본 키는 `FLAVOR` 입니다.

| NAME | TYPE | NULLABLE |
|---|---|---|
| SHIPMENT_ID | INT (N) | FALSE |
| FLAVOR | VARCHAR (N) | FALSE |
| TOTAL_ORDER | INT (N) | FALSE |

`ICECREAM_INFO` 테이블 구조는 다음과 같으며, `FLAVOR`, `INGREDITENT_TYPE` 은 각각 아이스크림 맛, 아이스크림의 성분 타입을 나타냅니다. `INGREDIENT_TYPE` 에는 아이스크림의 주 성분이 설탕이면 `sugar_based` 라고 입력되고, 아이스크림의 주 성분이 과일이면 `fruit_based` 라고 입력됩니다. `ICECREAM_INFO` 의 기본 키는 `FLAVOR` 입니다. `ICECREAM_INFO` 테이블의 `FLAVOR` 는 `FIRST_HALF` 테이블의 `FLAVOR` 의 외래 키입니다.

| NAME | TYPE | NULLABLE |
|---|---|---|
| FLAVOR | VARCHAR (N) | FALSE |
| INGREDIENT_TYPE | VARCHAR (N) | FALSE |

## 문제

상반기 아이스크림 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회하는 SQL 문을 작성해주세요.

## 예시

예를 들어 `FIRST_HALF` 테이블이 다음과 같고

| SHIPMENT_ID | FLAVOR | TOTAL_ORDER |
|---|---|---|
| 101 | chocolate | 3200 |
| 102 | vanilla | 2800 |
| 103 | mint_chocolate | 1700 |
| 104 | caramel | 2600 |
| 105 | white_chocolate | 3100 |
| 106 | peach | 2450 |
| 107 | watermelon | 2150 |
| 108 | mango | 2900 |
| 109 | strawberry | 3100 |
| 110 | melon | 3150 |
| 111 | orange | 2900 |
| 112 | pineapple | 2900 |

`ICECREAM_INFO` 테이블이 다음과 같다면

| FLAVOR | INGREDIENT_TYPE |
|---|---|
| chocolate | sugar_based |
| vanilla | sugar_based |
| mint_chocolate | sugar_based |
| caramel | sugar_based |
| white_chocolate | sugar_based |
| peach | fruit_based |
| watermelon | fruit_based |
| mango | fruit_based |
| strawberry | fruit_based |
| melon | fruit_based |
| orange | fruit_based |
| pineapple | fruit_based |

상반기 아이스크림 총주문량이 3,000보다 높은 아이스크림 맛은 chocolate, strawberry, melon, white_chocolate입니다. 이 중에 아이스크림의 주 성분이 과일인 아이스크림 맛은 strawberry와 melon이고 총주문량이 큰 순서대로 아이스크림 맛을 조회하면 melon, strawberry 순으로 조회되어야 합니다. 따라서 SQL 문을 실행하면 다음과 같이 나와야 합니다.

| FLAVOR |
|---|
| melon |
| strawberry |

## 풀이

```sql
SELECT F.FLAVOR
FROM FIRST_HALF F 
JOIN ICECREAM_INFO I 
    ON F.FLAVOR = I.FLAVOR
WHERE F.TOTAL_ORDER > 3000 
    AND I.INGREDIENT_TYPE = 'fruit_based'
ORDER BY F.TOTAL_ORDER DESC;
```

- 조인 기준: `FLAVOR` → 두 테이블의 공통 컬럼
- 조인 방법: `INNER JOIN`
    - 두 테이블에 모두 존재하면서 주문량, 성분 조건을 만족하는 데이터가 필요하므로, `LEFT OUTER JOIN`, `RIGHT OUTER JOIN`, `FULL OUTER JOIN`처럼 한쪽에만 있는 데이터까지 가져올 필요가 없음
        - 위 문제에서는 `LEFT OUTER JOIN`과 `RIGHT OUTER JOIN`을 사용해도 결과 동일
            - 매칭되지 않은 행은 반대쪽 컬럼이 `NULL`이 됨
            - 이후 `WHERE` 조건에서 `NULL`인 행이 제외되므로 최종적으로 양쪽에 매칭된 행만 남음
    - `INNER JOIN`은 `INNER` 생략하여 작성 가능. 따라서 `INNER JOIN = JOIN`. 단, 그 외(예: `LEFT`, `RIGHT`, `FULL`)는 생략 불가
    - `F.FLAVOR = I.FLAVOR`로 조인했으므로 `F.FLAVOR`, `I.FLAVOR` 중 어느 것을 조회(`SELECT`)해도 결과 동일
    - 단, `FLAVOR`는 양쪽 메이블에 모두 존재하므로 `SELECT FLAVOR`처럼 테이블명 생략 시 모호성 오류가 발생 가능하므로 위처럼(`F.FLAVOR`) 테이블을 지정하는 것을 추천
- **조인 종류**

    | JOIN 종류 | 생략 표현 | 조회 범위 | 매칭되지 않은 데이터 | 핵심 |
    |---|---|---|---|---|
    | `INNER JOIN` | `JOIN` | 양쪽 테이블에서 조건이 일치하는 행만 | 제외 | 교집합 |
    | `LEFT OUTER JOIN` | `LEFT JOIN` | 왼쪽 전체 + 오른쪽 일치 행 | 오른쪽 값이 `NULL` | 왼쪽 기준 |
    | `RIGHT OUTER JOIN` | `RIGHT JOIN` | 오른쪽 전체 + 왼쪽 일치 행 | 왼쪽 값이 `NULL` | 오른쪽 기준 |
    | `FULL OUTER JOIN` | `FULL JOIN` | 양쪽 테이블의 모든 행 | 반대쪽 값이 `NULL` | 양쪽 전체 |
    | `CROSS JOIN` | - | 두 테이블의 모든 행을 서로 조합 | 해당 없음 | A행 수 × B행 수, 가능한 모든 조합 |
    | `SELF JOIN` | - | 하나의 테이블을 자기 자신과 조인 | 조인 방식에 따라 다름 | 같은 테이블끼리 조인 |
    
    - `INNER`와 `OUTER`는 생략 가능

## 다른 풀이

```sql
-- IN 서브쿼리
SELECT FLAVOR
FROM FIRST_HALF
WHERE TOTAL_ORDER > 3000
    AND FLAVOR IN (
        SELECT FLAVOR
        FROM ICECREAM_INFO
        WHERE INGREDIENT_TYPE = 'fruit_based'
    )
ORDER BY TOTAL_ORDER DESC;
```

- `IN()`: 서브쿼리 결과의 값 목록과 비교

```sql
-- EXISTS
SELECT F.FLAVOR
FROM FIRST_HALF F
WHERE F.TOTAL_ORDER > 3000
    AND EXISTS (
        SELECT 1
        FROM ICECREAM_INFO I
        WHERE I.FLAVOR = F.FLAVOR
            AND I.INGREDIENT_TYPE = 'fruit_based'
    )
ORDER BY TOTAL_ORDER DESC;
```
- `EXISTS()`: 서브쿼리 조건을 만족하는 행이 하나라도 존재하는지 해당 여부만 확인
    - 조회 결과값은 무의미하므로 관례적으로 `SELECT 1` 사용
- 바깥 쿼리의 값을 안쪽 서브쿼리에서 참조하는 상관 서브쿼리이므로 모호성 오류 방지를 위해 별칭 사용

- `EXISTS()` vs `NOT EXISTS()`
    | 구분 | 의미 | TRUE가 되는 경우 |
    |---|---|---|
    | `EXISTS` | 조건을 만족하는 행이 **하나라도 존재** | 1개 이상 존재할 때 |
    | `NOT EXISTS` | 조건을 만족하는 행이 **하나도 존재하지 않음** | 0개일 때 |
    
    - `EXISTS`, `NOT EXISTS`는 조회값이 아닌 **행의 존재 여부**만 확인하므로 관례적으로 `SELECT 1` 사용