package intro;

/*
📌 No34. 문자열 내림차순으로 배치하기 (답안 2가지)
문제 링크:
https://school.programmers.co.kr/learn/courses/30/lessons/12917

📝 문제 설명:
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

🚫 제한 사항:
str은 길이 1 이상인 문자열입니다.
*/

import java.util.Arrays;

public class No34 {
    // 1. StringBuilder 활용
    public String solution(String s) {
        char[] arr = s.toCharArray();

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder(new String(arr));
        return sb.reverse().toString();
    }

    // 2. 배열 뒤집기
    public String solution2(String s) {
        char[] arr = s.toCharArray();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return new String(arr);
    }
}
