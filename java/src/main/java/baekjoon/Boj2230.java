package baekjoon;

import java.io.*;
import java.util.*;

public class Boj2230 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int m = Integer.parseInt(param[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int p1 = 0, p2 = 0;
        int min = Integer.MAX_VALUE;
        while (p1 < n && p2 < n) {
            int gap = Math.abs(arr[p1] - arr[p2]);
            if (gap < m) {
                p1++;
            } else {
                min = Math.min(min, gap);
                p2++;
            }
        }

        System.out.println(min);
    }
}
