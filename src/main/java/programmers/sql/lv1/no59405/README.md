# Lv 1. 상위 n개 레코드 (No. 59405)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/59405)

## 문제 설명

`ANIMAL_INS` 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. `ANIMAL_INS` 테이블 구조는 다음과 같으며, `ANIMAL_ID`, `ANIMAL_TYPE`, `DATETIME`, `INTAKE_CONDITION`, `NAME`, `SEX_UPON_INTAKE`는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

| NAME | TYPE | NULLABLE |
|---|---|---|
| ANIMAL_ID | VARCHAR (N) | FALSE |
| ANIMAL_TYPE | VARCHAR (N) | FALSE |
| DATETIME | DATETIME | FALSE |
| INTAKE_CONDITION | VARCHAR (N) | FALSE |
| NAME | VARCHAR (N) | TRUE |
| SEX_UPON_INTAKE | VARCHAR (N) | FALSE |

동물 보호소에 가장 먼저 들어온 동물의 이름을 조회하는 SQL 문을 작성해주세요.

## 예시

예를 들어 `ANIMAL_INS` 테이블이 다음과 같다면

| ANIMAL_ID | ANIMAL_TYPE | DATETIME | INTAKE_CONDITION | NAME | SEX_UPON_INTAKE |
|---|---|---|---|---|---|
| A399552 | Dog | 2013-10-14 15:38:00 | Normal | Jack | Neutered Male |
| A379998 | Dog | 2013-10-23 11:42:00 | Normal | Disciple | Intact Male |
| A370852 | Dog | 2013-11-03 15:04:00 | Normal | Katie | Spayed Female |
| A403564 | Dog | 2013-11-18 17:03:00 | Normal | Anna | Spayed Female |

이 중 가장 보호소에 먼저 들어온 동물은 Jack입니다. 따라서 SQL문을 실행하면 다음과 같이 나와야 합니다.

| NAME |
|---|
| Jack |

※ 보호소에 가장 먼저 들어온 동물은 한 마리인 경우만 테스트 케이스로 주어집니다.

## 풀이

```sql
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1;
```
- `LIMIT n`: 조회 결과 중 상위 n개 레코드만 가져옴
- `ASC`: 기본 정렬 방식이므로 생략 가능

## 다른 풀이

```sql
-- 서브쿼리 활용
SELECT NAME
FROM ANIMAL_INS
WHERE DATETIME = (
    SELECT MIN(DATETIME)
    FROM ANIMAL_INS
)
```
- 서브쿼리(Subquery): SQL 문 내부에서 실행되는 또 다른 SQL 문으로, 여기서는 `WHERE`에서 비교할 값을 구하는 역할
    ```sql
    SELECT 컬럼
    FROM 테이블
    WHERE 컬럼 = (
        SELECT ...
    );
    ```
- `MIN(컬럼명)`: 해당 컬럼에서 최솟값을 구하는 집계 함수

    → 따라서 
    ```sql
    DATETIME = (
        SELECT MIN(DATETIME)
        FROM ANIMAL_INS
    )
    ```
    는 `WHERE DATETIME = 가장 이른 DATETIME`라는 의미