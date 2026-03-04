package programmers.java.lv0.no120806;

public class No120806 {
    // 방법 1
    public int solution1(int num1, int num2) {
        double quotient;
        int result;

        quotient = (double) num1 / num2;
        result = (int) (quotient * 1000);

        return result;
    }

    // 방법 2
    public int solution2(int num1, int num2) {
        return (int)(((double) num1 / num2) * 1000);
    }

    // 방법 3
    public int solution3(int num1, int num2) {
        return (num1 * 1000) / num2;
    }
}
