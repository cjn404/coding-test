package nbcamp.java;

/*
📌 No3. 몫 구하기 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120805

📝 문제 설명:
정수 num1, num2가 매개변수로 주어질 때, num1을 num2로 나눈 몫을 return 하도록 solution 함수를 완성해주세요.

🚫 제한 사항:
0 < num1 ≤ 100
0 < num2 ≤ 100
*/

public class No3 {
    // 1. 기본 나눗셈 반환 방식
    public int solution1(int num1, int num2) {
        return num1 / num2;
    }

    // 2. 조건 검사를 통한 유효성 확인 후 나눗셈
    public int solution2(int num1, int num2) {
        if (num1 > 0 && num1 <= 100 && num2 > 0 && num2 <= 100) {
            return num1 / num2;
        }
        return 0;
    }

    // 3. 예외 처리로 입력 제한 위반 명시
    public int solution3(int num1, int num2) {
        if (num1 <= 0 || num1 > 100 || num2 <= 0 || num2 > 100) {
            throw new IllegalArgumentException("num1과 num2는 0 초과 100 이하이어야 합니다.");
        }
        return num1 / num2;
    }
}
