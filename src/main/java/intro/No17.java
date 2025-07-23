package intro;

/*
📌 No17. 자연수 뒤집어 배열로 만들기 (답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12932

📝 문제 설명:
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

🚫 제한 사항:
n은 10,000,000,000이하인 자연수입니다.
*/

public class No17 {
    public int[] solution1(long n) {
        String str = String.valueOf(n);
        int[] answer = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            answer[i] = str.charAt(str.length() - 1 - i) - '0';
        }
        return answer;
    }

    public int[] solution2(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];

        for (int i =0; i < str.length(); i++) {
            answer[i] = str.charAt(str.length() - 1 - i) - '0';
        }
        return answer;
    }

    public int[] solution3(long n) {
        String str = n + "";
        int[] answer = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            answer[i] = str.charAt(str.length() - 1 - i) - '0';
        }
        return answer;
    }
}
