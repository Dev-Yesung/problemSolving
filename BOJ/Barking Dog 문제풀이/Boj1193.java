package ps;

import java.util.*;

public class Boj1193 {
    static Scanner sc = new Scanner(System.in);
    static int sum = 0;
    static int last = 0;
    static boolean isRight = true;

    public static void main(String[] args) {
        int x = sc.nextInt();
        recursion(1, x);

        int top = isRight ? 1 : last - 1;
        int bot = isRight ? last - 1 : 1;

        int count = x - sum;
        for (int i = 1; i < count; i++) {
            if (isRight) {
                top++;
                bot--;
            } else {
                top--;
                bot++;
            }
        }

        System.out.println(top + "/" + bot);
    }

    static void recursion(int start, int t) {
        if (sum >= t) {
            sum -= start - 1;
            return;
        }

        isRight = !isRight;
        sum += start;
        last = start + 1;
        recursion(start + 1, t);
    }
}
