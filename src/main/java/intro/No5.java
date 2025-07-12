package intro;

/*
📌 No5. 숫자 비교하기 (답안 2가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120807

📝 문제 설명:
정수 num1과 num2가 매개변수로 주어집니다. 두 수가 같으면 1 다르면 -1을 retrun하도록 solution 함수를 완성해주세요.

🚫 제한 사항:
0 ≤ num1 ≤ 10,000
0 ≤ num2 ≤ 10,000
*/

public class No5 {
    public int solution1(int num1, int num2) {
        int answer = 0;
        if (num1 == num2) {
            return 1;
        } else {
            return -1;
        }
    }

    // 삼항 연산자 사용
    public int solution2(int num1, int num2) {
        return (num1 == num2) ? 1 : -1;
    }
}