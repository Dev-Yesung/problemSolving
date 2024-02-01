package ps;

import java.io.*;
import java.util.*;

public class Boj15652 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] series = new int[10];
    static int N, M;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        solution(0);

        System.out.println(sb);
    }

    static void solution(int size) {
        if (size == M) {
            for (int i = 0; i < M; i++) {
                sb.append(series[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int start = 1;
        if (size != 0) {
            start = series[size - 1];
        }
        for (int i = start; i <= N; i++) {
            series[size] = i;
            solution(size + 1);
        }
    }
}
