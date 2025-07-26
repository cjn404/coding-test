package intro;

/*
📌 No20. 정수 내림차순으로 배치하기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12933

📝 문제 설명:
함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

🚫 제한 사항:
n은 1이상 8000000000 이하인 자연수입니다.
*/

import java.util.*;

public class No20 {

    public long solution(long n) {
        String str = Long.toString(n);

        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        Arrays.sort(arr);

        char[] result = new char[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            result[j] = arr[i];
        }

        String finalStr = new String(result);

        return Long.parseLong(finalStr);
    }
}
