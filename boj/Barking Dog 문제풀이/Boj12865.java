package ps;

import java.io.*;
import java.util.*;

// 평범한 배낭
// 그리디인지 DP 인지 구분할 수 있어야 한다!
// 같이 풀어볼 문제
// 1477,
// https://st-lab.tistory.com/141
class Boj12865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            w[i] = Integer.parseInt(input[0]);
            v[i] = Integer.parseInt(input[1]);
        }
        // dp 테이블을 어떻게 만들어야 할까?
        // -> DP 문제 풀 때는 점화식을 세우는 연습을 항상 해야한다.
        int[][] dp = new int[n + 1][k + 1];
        for (int maxW = 1; maxW <= k; maxW++) {
            for (int i = 1; i <= n; i++) {
                if (w[i] > maxW) {
                    dp[i][maxW] = dp[i - 1][maxW];
                }
                if (w[i] <= maxW) {
                    dp[i][maxW] = Math.max(dp[i - 1][maxW], dp[i - 1][maxW - w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
