package intro;

/*
📌 No19. 정수 제곱근 판별
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12934

📝 문제 설명:
임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

🚫 제한 사항:
n은 1이상, 50000000000000 이하인 양의 정수입니다.
*/

public class No19 {
    public long solution(long n) {
        long x = (long) Math.sqrt(n);

        if (x * x == n) {
            return (x + 1) * (x + 1);
        } else {
            return -1;
        }
    }
}

