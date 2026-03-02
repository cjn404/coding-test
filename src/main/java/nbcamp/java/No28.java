package nbcamp.java;

/*
📌 No28. 없는 숫자 더하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12948

📝 문제 설명:
0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

🚫 제한 사항:
1 ≤ numbers의 길이 ≤ 9
0 ≤ numbers의 모든 원소 ≤ 9
numbers의 모든 원소는 서로 다릅니다.
*/

public class No28 {
    public int solution(int[] numbers) {
        int total = 0;
        int sum = 0;

        for (int i = 0; i <= 9; i++) {
            total += i;
        }

        for (int number : numbers) {
            sum += number;
        }
        return total - sum;
    }
}
