package intro;

/*
📌 No13. 자릿수 더하기 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12931

📝 문제 설명:
자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

🚫 제한 사항:
N의 범위 : 100,000,000 이하의 자연수
*/

import java.util.*;

public class No13 {
    public int solution1(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // String.valueOf()로 숫자 -> 문자열 변환
    public int solution2(int n) {
        String str = String.valueOf(n);
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }

    // Integer.toString()로 숫자 -> 문자열 변환
    public int solution3(int n) {
        String str = Integer.toString(n);
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }
}