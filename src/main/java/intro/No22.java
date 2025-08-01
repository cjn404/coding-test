package intro;

/*
📌 No22. 두 정수 사이의 합 (답안 2가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12912

📝 문제 설명:
두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.

🚫 제한 사항:
a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
a와 b의 대소관계는 정해져있지 않습니다.
*/

public class No22 {
    // 1. 반복문 사용 (시간복잡도 O(N))
    public long solution(int a, int b) {
        long sum = 0;
        long start = Math.min(a, b);
        long end = Math.max(a, b);

        for (long i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    // 2. 등차수열 공식 (시간복잡도 O(1))
    public long solution2(int a, int b) {
      long start = Math.min(a, b);
      long end = Math.max(a, b);
      long n = end - start + 1;

      return (start + end) * n / 2;
    }
}
