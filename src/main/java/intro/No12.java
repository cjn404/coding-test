package intro;

/*
📌 No12. 평균 구하기 (답안 4가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12944

📝 문제 설명:
정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

🚫 제한 사항:
arr은 길이 1 이상, 100 이하인 배열입니다.
arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
*/

import java.util.Arrays;

public class No12 {
    public double solution1(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }

    public double solution2(int[] arr) {
        int sum = 0;
        for(int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    // 값이 없으면 기본값 0 반환
    public double solution3(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }

    // 값이 없으면 NoSuchElementException 예외 자동 던짐(throw)
    public double solution4(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
        }
}

