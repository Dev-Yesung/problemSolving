package baekjoon;

import java.io.*;
import java.util.*;

public class Boj2217 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();

        int w = Integer.MIN_VALUE;
        for (int idx = 1; idx <= n; idx++) {
            int val = sortedArr[n - idx] * idx;
            if (w < val) {
                w = val;
            }
        }
        System.out.println(w);
    }
}
