package intro;

/*
📌 No21. 하샤드 수
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12947

📝 문제 설명:
양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

🚫 제한 사항:
x는 1 이상, 10000 이하인 정수입니다.
*/

public class No21 {
    public boolean solution(int x) {
        int original = x;
        int digitSum = 0;

        while (x > 0) {
            digitSum += x % 10;
            x /= 10;
        }
        return original % digitSum == 0;
    }
}
