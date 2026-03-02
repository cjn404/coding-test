package nbcamp.java;

/*
📌 No40. 3진법 뒤집기(답안 3가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68935

📝 문제 설명:
자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

🚫 제한 사항:
n은 1 이상 100,000,000 이하인 자연수입니다.
*/

public class No40 {
    public int solution1(int n) {
        String str = Integer.toString(n, 3);
        String reversed = new StringBuilder(str).reverse().toString();
        return Integer.parseInt(reversed);
    }

    public int solution2(int n) {
        String str = "";

        while (n != 0) {
            str += n % 3;
            n /= 3;
        }
        return Integer.parseInt(str);
    }

    public int solution3(int n) {
        int result = 0;
        int temp = n;

        while (temp > 0) {
            int remainder = temp % 3;
            result = result * 3 + remainder;
            temp /= 3;
        }
        return result;
    }
}
