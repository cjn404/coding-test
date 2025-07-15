package intro;

/*
📌 No9. 짝수의 합 (답안 2가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120831

📝 문제 설명:
정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.

🚫 제한 사항:
0 < n ≤ 1000
*/

public class No9 {
    public int solution1(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            if (i % 2 ==0) {
                sum += i ;
            }
        }
        return sum;
    }

    public int solution2(int n) {
        int sum = 0;
        for(int i = 2; i <= n; i += 2) {
            sum += i ;
        }
        return sum;
    }
}
