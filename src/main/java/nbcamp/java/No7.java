package nbcamp.java;

/*
📌 No7. 두 수의 나눗셈 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120806

📝 문제 설명:
정수 num1과 num2가 매개변수로 주어질 때, num1을 num2로 나눈 값에 1,000을 곱한 후 정수 부분을 return 하도록 solution 함수를 완성해주세요.

🚫 제한 사항:
0 < num1 ≤ 100
0 < num2 ≤ 100
*/

public class No7 {
    public int solution1(int num1, int num2) {
        double result = (double) num1 / num2;
        result = result * 1000;
        return (int) result;
    }

    public int solution2(int num1, int num2) {
        return (int) (((double) num1 / num2) * 1000);
    }

    public int solution3(int num1, int num2) {
        return (num1 * 1000) / num2;
    }
}
