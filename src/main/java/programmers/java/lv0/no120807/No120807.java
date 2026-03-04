package programmers.java.lv0.no120807;

public class No120807 {
   // 방법 1
    public int solution1(int num1, int num2) {
        if (num1 == num2) {
            return 1;
        } else {
            return -1;
        }
    }

    // 방법 2
    public int solution2(int num1, int num2) {
        return (num1 == num2) ? 1 : -1;
    }
}
