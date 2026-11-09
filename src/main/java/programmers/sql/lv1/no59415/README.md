# Lv. 1 최댓값 구하기 (No. 59415)

[🔗 문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/59415)

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

가장 최근에 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.

## 예시

예를 들어 `ANIMAL_INS` 테이블이 다음과 같다면

| ANIMAL_ID | ANIMAL_TYPE | DATETIME | INTAKE_CONDITION | NAME | SEX_UPON_INTAKE |
|---|---|---|---|---|---|
| A399552 | Dog | 2013-10-14 15:38:00 | Normal | Jack | Neutered Male |
| A379998 | Dog | 2013-10-23 11:42:00 | Normal | Disciple | Intact Male |
| A370852 | Dog | 2013-11-03 15:04:00 | Normal | Katie | Spayed Female |
| A403564 | Dog | 2013-11-18 17:03:00 | Normal | Anna | Spayed Female |

가장 늦게 들어온 동물은 Anna이고, Anna는 2013-11-18 17:03:00에 들어왔습니다. 따라서 SQL문을 실행하면 다음과 같이 나와야 합니다.

| 시간 |
|---|
| 2013-11-18 17:03:00 |

※ 컬럼 이름 (위 예제에서는 "시간")은 일치하지 않아도 됩니다.

## 풀이

```sql
SELECT MAX(DATETIME) 시간
FROM ANIMAL_INS;
```
- `AS`: 조회 결과의 컬럼에 별칭(Alias)을 지정하며, 생략 가능
- `MAX(컬럼명)`: 해당 컬럼의 최댓값 조회 
  - 위 쿼리에서는 최대 `DATETIME` = 가장 최근에 들어온 시간 의미
  ↔ `MIN(컬럼명)`: 해당 컬럼의 최솟값 조회
- 별칭 표기
  
  | 표기 | 의미 | 사용 |
  |---|---|---|
  | `시간` | 일반적인 식별자로 사용 | 가능 |
  | `` `시간` `` | 식별자를 명확하게 감싸서 사용 | 추천 |
  | `'시간'` | 문자열 표기이며 MySQL에서는 별칭 선언 시 허용 | ⚠️ 비추천 |
  | `"시간"` | DBMS 및 SQL 설정에 따라 식별자 또는 문자열로 해석 | ⚠️ 비추천 |
  - 일반적인 영어·숫자·한글 식별자: 백틱 생략 가능
  - 공백·특수문자·예약어가 포함된 식별자: 백틱 사용

## 다른 풀이

```sql
SELECT DATETIME 시간
FROM ANIMAL_INS
ORDER BY DATETIME DESC 
LIMIT 1;
```
- `DESC`: 큰 값부터 작은 값 순으로 정렬
  - 위 쿼리에서는 가장 최근 날짜부터 정렬
- `LIMIT n`: 정렬 결과에서 위에서부터 n 번째 행만 조회