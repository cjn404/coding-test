package intro;

/*
📌 No10. 배열의 평균값 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120817

📝 문제 설명:
정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요.

🚫 제한 사항:
0 ≤ numbers의 원소 ≤ 1,000
1 ≤ numbers의 길이 ≤ 100
정답의 소수 부분이 .0 또는 .5인 경우만 입력으로 주어집니다.
*/

import java.util.Arrays;

public class No10 {
    public double solution1(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        } return (double) sum / numbers.length;
    }

    public double solution2(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        } return (double) sum / numbers.length;
    }

    public double solution3(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
    }
}
