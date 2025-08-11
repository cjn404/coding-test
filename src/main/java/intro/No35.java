package intro;

/*
📌 No35. 부족한 금액 계산하기 (답안 2가지)
문제 링크:
https://school.programmers.co.kr/learn/courses/30/lessons/82612

📝 문제 설명:
새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. 이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. 즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
단, 금액이 부족하지 않으면 0을 return 하세요.

🚫 제한 사항:
놀이기구의 이용료 price : 1 ≤ price ≤ 2,500, price는 자연수
처음 가지고 있던 금액 money : 1 ≤ money ≤ 1,000,000,000, money는 자연수
놀이기구의 이용 횟수 count : 1 ≤ count ≤ 2,500, count는 자연수
*/

public class No35 {
    public long solution(int price, int money, int count) {
        // 1. 등차수열 합 공식 활용: n (n + 1) / 2
        long totalCost = (long) price * count * (count + 1) / 2;

        long shortage = totalCost - money;

        return shortage > 0 ? shortage : 0;
    }

    public long solution2(int price, int money, int count) {
        // 2. 등차수열 합 공식 X, for 문으로
        long totalCost = 0;

        for (int i = 1; i <= count; i++) {
            totalCost += (long) price * i;
        }

        long shortage = totalCost - money;
        return shortage > 0 ? shortage : 0;
    }
}
