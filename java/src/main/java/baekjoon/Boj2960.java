package baekjoon;

import java.io.*;
import java.util.*;

class Boj2960 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int k = Integer.parseInt(param[1]);

        boolean[] isErased = new boolean[n + 1];
        isErased[0] = true;
        isErased[1] = true;
        int step = 0;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; i * j <= n; j++) {
                if (!isErased[i * j]) {
                    isErased[i * j] = true;
                    step++;
                }
                if (step == k) {
                    ans = i * j;
                    break;
                }
            }
            if (step == k) {
                break;
            }
        }

        System.out.println(ans);
    }
}
