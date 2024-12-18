package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1182 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] numbers = new int[20];
    static int N, S;
    static int count;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        String nums = br.readLine();
        StringTokenizer st = new StringTokenizer(nums, " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);

        if (S == 0) {
            count--;
        }
        System.out.println(count);
    }

    static void solution(int cur, int total) {
        if (cur == N) {
            if (total == S) {
                count++;
            }
            return;
        }

        solution(cur + 1, total);
        solution(cur + 1, total + numbers[cur]);
    }
}
