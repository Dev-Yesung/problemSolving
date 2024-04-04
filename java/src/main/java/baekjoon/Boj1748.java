package baekjoon;

import java.io.*;
import java.util.*;

class Boj1748 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] cnt = new int[10];
        int digit = (int) Math.log10(n) + 1;
        for (int i = 1; i <= digit; i++) {
            if (i != digit) {
                cnt[i] = (int) Math.pow(10, i) - (int) Math.pow(10, i - 1);
            } else {
                cnt[i] = n - ((int) Math.pow(10, i - 1) - 1);
            }
        }

        int ans = 0;
        for (int i = 1; i <= 9; i++) {
            if (cnt[i] != 0) {
                ans += cnt[i] * i;
            }
        }

        System.out.println(ans);
    }
}
