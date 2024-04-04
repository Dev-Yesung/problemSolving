package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int s = Integer.parseInt(param[1]);

        int[] arr = new int[n + 1];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        int p1 = 0, p2 = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (p1 <= n && p2 <= n) {
            if (sum >= s) {
                min = Math.min(min, p2 - p1);
            }

            if (sum < s) {
                sum += arr[p2];
                p2++;
            } else {
                sum -= arr[p1];
                p1++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println('0');
        } else {
            System.out.println(min);
        }
    }
}
