package intro;

/*
📌 No30. 가운데 글자 가져오기
문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12903

📝 문제 설명:
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

🚫 제한 사항:
s는 길이가 1 이상, 100이하인 스트링입니다.
*/

public class No30 {
    public String solution(String s) {
        int len = s.length();
        int mid = len / 2;

        if (len % 2 == 0) {
            return s.substring(mid - 1, mid + 1);
        } else {
            return s.substring(mid, mid + 1);
        }
    }
}
