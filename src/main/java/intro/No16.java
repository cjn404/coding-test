package intro;

/*
📌 No16. x만큼 간격이 있는 n개의 숫자 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12954

📝 문제 설명:
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

🚫 제한 사항:
x는 -10000000 이상, 10000000 이하인 정수입니다.
n은 1000 이하인 자연수입니다.
*/

public class No16 {
    // 1. 1부터 n까지 곱해서 x부터 시작
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }

        return answer;
    }

    // 2. 누적 합을 이용해 x부터 시작
    public long[] solution2(int x, int n) {
        long[] answer = new long[n];
        long sum = 0;

        for (int i = 0; i < answer.length; i++) {
            sum += x;
            answer[i] = sum;
        }
        return answer;
    }

    // 3. 이전 값에 x를 더해가며 x부터 시작
    public long[] solution3(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < answer.length; i++) {
            answer[i] = answer[i - 1] + x;
        }
        return answer;
    }
}
