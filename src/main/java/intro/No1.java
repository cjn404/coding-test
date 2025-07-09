package intro;

/*
📌 No1. 두 수의 차 구하기 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120803

📝 문제 설명:
정수 num1과 num2가 주어질 때, num1에서 num2를 뺀 값을 return 하도록 solution 함수를 완성해주세요.

🚫 제한 사항:
-50000 ≤ num1 ≤ 50000
-50000 ≤ num2 ≤ 50000
*/


public class No1 {
    // 1. 기본 뺄셈 반환 방식
    public int solution1(int num1, int num2) {
        return num1 - num2;
    }

    // 2. 뺄셈 값을 변수에 저장한 후 반환
    public int solution2(int num1, int num2) {
        int sub = num1 - num2;
        return sub;
    }

    // 3. 조건 검사를 통한 유효성 확인 후 뺄셈
    public int solution3(int num1, int num2) {
        if (num1 >= -50000 && num1 <= 50000 && num2 >= -50000 && num2 <= 50000) {
            return num1 - num2;
        } return 0;
    }
}
