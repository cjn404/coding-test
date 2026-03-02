package nbcamp.java;

/*
📌 No11. 짝수와 홀수 (답안 2가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12937

📝 문제 설명:
정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.

🚫 제한 사항:
num은 int 범위의 정수입니다.
0은 짝수입니다.
*/

public class No11 {
    public String solution1(int num) {
        String answer;
        if (num % 2 == 0) {
            answer = "Even";
        } else {answer = "Odd";
        } return answer;
    }

    public String solution2(int num) {
        return (num % 2 == 0 ) ? "Even" : "Odd";
    }
}


