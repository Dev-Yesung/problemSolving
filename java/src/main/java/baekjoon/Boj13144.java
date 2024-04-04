package baekjoon;

import java.io.*;
import java.util.*;

public class Boj13144 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] nums;
    static boolean[] isUsed = new boolean[100_001];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int parsed = Integer.parseInt(line[i]);
            nums[i] = parsed;
        }

        int left = 0, right = 0;
        int cnt = 0;
        while (left < n) {
            if (isUsed[nums[left]]) {
                isUsed[nums[left]] = false;
                left++;
                continue;
            }

            while (right < n && !isUsed[nums[right]]) {
                isUsed[nums[right]] = true;
                right++;
            }

            cnt += (right - left);
        }

        System.out.println(cnt);
    }
}
