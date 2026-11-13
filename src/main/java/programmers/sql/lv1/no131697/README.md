# Lv 1. 가장 비싼 상품 구하기 (No. 131697)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/131697)

## 문제 설명

다음은 어느 의류 쇼핑몰에서 판매 중인 상품들의 정보를 담은 `PRODUCT` 테이블입니다. `PRODUCT` 테이블은 아래와 같은 구조로 되어있으며, `PRODUCT_ID`, `PRODUCT_CODE`, `PRICE` 는 각각 상품 ID, 상품코드, 판매가를 나타냅니다.

| Column name | Type | Nullable |
|---|---|---|
| PRODUCT_ID | INTEGER | FALSE |
| PRODUCT_CODE | VARCHAR (8) | FALSE |
| PRICE | INTEGER | FALSE |

상품 별로 중복되지 않는 8자리 상품코드 값을 가지며, 앞 2자리는 카테고리 코드를 의미합니다.

## 문제

`PRODUCT` 테이블에서 판매 중인 상품 중 가장 높은 판매가를 출력하는 SQL문을 작성해주세요. 이때 컬럼명은 `MAX_PRICE`로 지정해주세요.

## 예시

예를 들어 `PRODUCT` 테이블이 다음과 같다면

| PRODUCT_ID | PRODUCT_CODE | PRICE |
|---|---|---|
| 1 | A1000001 | 10000 |
| 2 | A2000005 | 9000 |
| 3 | C1000006 | 22000 |

가장 높은 판매가는 22,000 원 이므로, 다음과 같은 결과가 나와야 합니다.

| MAX_PRICE |
|---|
| 22000 |

## 풀이

```sql
SELECT MAX(PRICE) MAX_PRICE
FROM PRODUCT;
```

| 집계함수 | 용도 / 의미 | 주로 사용 가능한 타입 | 예시 |
|---|---|---|---|
| `COUNT()` | 행 또는 값의 개수를 계산 | 거의 모든 타입 | `COUNT(*)`, `COUNT(PRICE)` |
| `SUM()` | 값들의 합계를 계산 | 숫자 타입 | `SUM(PRICE)` |
| `AVG()` | 값들의 평균을 계산 | 숫자 타입 | `AVG(PRICE)` |
| `MAX()` | 가장 큰 값을 반환 | 숫자, 날짜, 문자열 등 | `MAX(PRICE)`, `MAX(JOINED)` |
| `MIN()` | 가장 작은 값을 반환 | 숫자, 날짜, 문자열 등 | `MIN(PRICE)`, `MIN(JOINED)` |

- **집계 합수는 기본적으로 `NULL`을 제외하고 계산하나, `COUNT(*)`은 NULL 여부와 관계 없이 모든 행을 셈**

## 다른 풀이

```sql
SELECT PRICE AS MAX_PRICE
FROM PRODUCT
ORDER BY PRICE DESC 
LIMIT 1;
```