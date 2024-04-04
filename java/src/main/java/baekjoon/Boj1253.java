package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1253 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(numbers);
        int cnt = 0;
        for (int idx = 0; idx < n; idx++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                if (left == idx) {
                    left++;
                    continue;
                } else if (right == idx) {
                    right--;
                    continue;
                }

                int sum = numbers[left] + numbers[right];
                if (sum > numbers[idx]) {
                    right--;
                } else if (sum < numbers[idx]) {
                    left++;
                } else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
