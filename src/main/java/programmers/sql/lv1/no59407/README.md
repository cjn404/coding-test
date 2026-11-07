# Lv 1. 이름이 있는 동물의 아이디 (No. 59407)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/59407)

## 문제 설명

`ANIMAL_INS` 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. `ANIMAL_INS` 테이블 구조는 다음과 같으며, `ANIMAL_ID`, `ANIMAL_TYPE`, `DATETIME`, `INTAKE_CONDITION`, `NAME`, `SEX_UPON_INTAKE` 는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

| NAME | TYPE | NULLABLE |
|---|---|---|
| ANIMAL_ID | VARCHAR (N) | FALSE |
| ANIMAL_TYPE | VARCHAR (N) | FALSE |
| DATETIME | DATETIME | FALSE |
| INTAKE_CONDITION | VARCHAR (N) | FALSE |
| NAME | VARCHAR (N) | TRUE |
| SEX_UPON_INTAKE | VARCHAR (N) | FALSE |

동물 보호소에 들어온 동물 중, 이름이 있는 동물의 ID를 조회하는 SQL 문을 작성해주세요. 단, ID는 오름차순 정렬되어야 합니다.

## 예시

예를 들어 `ANIMAL_INS` 테이블이 다음과 같다면

| ANIMAL_ID | ANIMAL_TYPE | DATETIME | INTAKE_CONDITION | NAME | SEX_UPON_INTAKE |
|---|---|---|---|---|---|
| A434523 | Cat | 2015-11-20 14:18:00 | Normal | NULL | Spayed Female |
| A562649 | Dog | 2014-03-20 18:06:00 | Sick | NULL | Spayed Female |
| A524634 | Dog | 2015-01-02 18:54:00 | Normal | \*Belle | Intact Female |
| A465637 | Dog | 2017-06-04 08:17:00 | Injured | \*Commander | Neutered Male |

이름이 있는 동물의 ID는 A524634와 A465637입니다. 따라서 SQL을 실행하면 다음과 같이 출력되어야 합니다.

| ANIMAL_ID |
|---|
| A465637 |
| A524634 |

## 풀이

- **일반적인 값 비교**: 비교 연산자 사용 가능 
  
  → 단, `NULL`은 일반적인 값이 아니라 값이 없거나 알 수 없는 상태를 의미하므로 비교 연산자로 확인 불가
  - **비교 연산자 종류**:

    ```sql
    -- 같다
    WHERE NAME = 'A'
    
    -- 같지 않다
    WHERE NAME != 'A'
    -- 같지 않다
    WHERE NAME <> 'A'
    ```

- **`NULL` 여부 확인**: 
    ```sql
    -- NULL임
    WHERE NAME IS NULL

    -- NULL이 아님
    WHERE NAME IS NOT NULL
    ```

- **결론**:
    | 조건 | 사용 |
    |---|---|
    | 특정 값과 같음 | `=` |
    | 특정 값과 다름 | `!=`, `<>` |
    | `NULL`임 | `IS NULL` |
    | `NULL`이 아님 | `IS NOT NULL` |

