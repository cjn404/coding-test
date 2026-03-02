package nbcamp.java;

/*
📌 No6. 두 수의 합 구하기 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120802

📝 문제 설명:
정수 num1과 num2가 주어질 때, num1과 num2의 합을 return하도록 soltuion 함수를 완성해주세요.

🚫 제한 사항:
-50,000 ≤ num1 ≤ 50,000
-50,000 ≤ num2 ≤ 50,000
*/

public class No6 {
    public int solution1(int num1, int num2) {
        return num1 + num2;
    }

    public int solution2(int num1, int num2) {
        if (-50000 <= num1 && num1 <= 50000 && -50000 <= num2 && num2 <= 50000) {
            return num1 + num2;
        }
        return 0;
    }

    public int solution3(int num1, int num2) {
        if (-50000 > num1 || num1 > 50000 || -50000 > num2 || num2 > 50000) {
            throw new IllegalArgumentException("num1과 num2는 -50,000 이상 50,000 이하이어야 합니다.");
        }
        return num1 + num2;
    }
}

