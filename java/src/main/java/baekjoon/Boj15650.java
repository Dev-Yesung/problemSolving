package baekjoon;

import java.io.*;
import java.util.*;

public class Boj15650 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] series = new int[10];
    static boolean[] isUsed = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        solution(1);

        System.out.println(sb);
    }

    static void solution(int size) {
        if (size == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(series[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int num = 1; num <= N; num++) {
            if (!isUsed[num] && series[size - 1] < num) {
                series[size] = num;
                isUsed[num] = true;
                solution(size + 1);
                isUsed[num] = false;
            }
        }
    }
}
