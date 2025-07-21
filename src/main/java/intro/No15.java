package intro;

/*
📌 No15. 나머지가 1이 되는 수 찾기 (답안 4가지)
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87389

📝 문제 설명:
자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 답이 항상 존재함은 증명될 수 있습니다.

🚫 제한 사항:
3 ≤ n ≤ 1,000,000
*/

public class No15 {
    public int solution1(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return -1; // for 문 이후에 반드시 return 있어야 함 -> 컴파일러를 위해 "찾는 값 없는" 경우 상정
    }

    public int solution2(int n) {
        int i = 1;
        for (; i < n; i++) {
            if (n % i == 1) {
                break;
            }
        }
        return i;
    }

    public int solution3(int n) {
        int i = 1;
        while (i < n) {
            if (n % i == 1)
                break;
            i++;
        }
        return i;
    }

    // 4. while 조건에 종료 조건 통합
    public int solution4(int n) {
        int i = 1;
        while (i < n && n % i != 1) {
            i++;
        }
        return i;
    }
}
