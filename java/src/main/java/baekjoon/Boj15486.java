package baekjoon;

import java.io.*;

public class Boj15486 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] times = new int[n + 1];
        int[] prices = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String[] param = br.readLine().split(" ");
            times[i] = Integer.parseInt(param[0]);
            prices[i] = Integer.parseInt(param[1]);
        }

        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, dp[i]);

            int nxt = i + times[i];
            if (nxt <= n) {
                dp[nxt] = Math.max(dp[nxt], max + prices[i]);
            }
        }

        System.out.println(max);
    }
}
