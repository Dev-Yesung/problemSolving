package ps;

import java.io.*;
import java.util.*;

public class Boj11729_ver2 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = sc.nextInt();
        // 하노이탑의 최소이동 횟수는 (2^N) - 1로 알려져 있다.
        int count = (1 << N) - 1;
        hanoiMove(1, 3, N);
        System.out.println(count);
        System.out.println(sb);
    }

    private static void hanoiMove(int start, int end, int n) {
        if (n == 1) {
            sb.append(start).append(' ').append(end).append('\n');
            return;
        }
        hanoiMove(start, 6 - start - end, n - 1);
        sb.append(start).append(' ').append(end).append('\n');
        hanoiMove(6 - start - end, end, n - 1);
    }
}
