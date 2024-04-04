package baekjoon;

import java.io.*;
import java.util.*;

public class Boj15654 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] numbers = new int[10];
    static boolean[] isUsed = new boolean[10_001];
    static int[] result = new int[10];
    static int N, M;

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers[i] = num;
        }
        Arrays.sort(numbers, 0, N);

        solution(0);
        System.out.println(sb);
    }

    static void solution(int size) {
        if (size == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[numbers[i]]) {
                result[size] = numbers[i];
                isUsed[numbers[i]] = true;
                solution(size + 1);
                isUsed[numbers[i]] = false;
            }
        }
    }
}
