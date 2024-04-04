package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj15655 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] num = new int[10];
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];
    static int N, M;

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(num, 0, N);

        solution(0);

        System.out.println(sb);
    }

    static void solution(int size) {
        if (size == M) {
            for (int i = 0; i < M; i++) {
                sb.append(num[arr[i]]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int start = 0;
        if (size != 0) {
            start = arr[size - 1] + 1;
        }

        for (int i = start; i < N; i++) {
            if (!isUsed[i]) {
                arr[size] = i;
                isUsed[i] = true;
                solution(size + 1);
                isUsed[i] = false;
            }
        }
    }
}
