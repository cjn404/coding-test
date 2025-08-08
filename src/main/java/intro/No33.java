package intro;

/*
📌 No33. 약수의 개수와 덧셈 (답안 2가지)
문제 링크:
https://school.programmers.co.kr/learn/courses/30/lessons/77884

📝 문제 설명:
두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

🚫 제한 사항:
1 ≤ left ≤ right ≤ 1,000
*/

public class No33 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                answer -= i;
            } else {
                answer += i;
            }
        }
        return answer;
    }

    public int solution2(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (isPerfectSquare(i)) {
                answer -= i;
            } else {
                answer += i;
            }
        }
        return answer;
    }

    private boolean isPerfectSquare(int i) {
        int sqrt = (int) Math.sqrt(i);
        // 묵시적
        return sqrt * sqrt == i;
        /*
        // 명시적
        if (sqrt * sqrt == i) {
            return true;
        } else {
            return false;
        }
        */
    }
}
