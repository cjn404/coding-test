package intro;

/*
📌 No25. 나누어 떨어지는 숫자 배열
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12910

📝 문제 설명:
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

🚫 제한 사항:
arr은 자연수를 담은 배열입니다.
정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
divisor는 자연수입니다.
array는 길이 1 이상인 배열입니다.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No25 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (i % divisor == 0) {
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
