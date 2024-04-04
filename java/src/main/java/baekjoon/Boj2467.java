package baekjoon;

import java.io.*;

public class Boj2467 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] param = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(param[i]);
        }

        int s = 0, e = n - 1;
        int minL = 0, minR = 0;
        long min = Long.MAX_VALUE;
        while (s < e) {
            long sum = arr[s] + arr[e];

            if (min >= Math.abs(sum)) {
                min = Math.abs(sum);
                minL = s;
                minR = e;
            }

            if (sum > 0) {
                e--;
            } else {
                s++;
            }
        }

        System.out.println(arr[minL] + " " + arr[minR]);
    }
}
