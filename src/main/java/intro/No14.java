package intro;

/*
📌 No14. 약수의 합
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12928

📝 문제 설명:
정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

🚫 제한 사항:
n은 0 이상 3000이하인 정수입니다.
*/

public class No14 {
    public int solution(int n) {
        int sum = 0;

        // n = 0은 약수가 없으므로 예외 처리
        if (n == 0)
            return 0;

        // 1부터 n까지 반복하면서 약수 확인 및 누적합
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}