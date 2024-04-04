package baekjoon;

import java.io.*;
import java.util.*;

public class Boj15649 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] series = new int[10];
    static boolean[] vis = new boolean[10];
    static int N, M;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        solution(0);

        System.out.println(sb);
    }

    static void solution(int idx) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(series[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!vis[i]) {
                series[idx] = i;
                vis[i] = true;
                solution(idx + 1);
                vis[i] = false;
            }
        }
    }

}
