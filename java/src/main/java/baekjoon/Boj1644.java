package baekjoon;

import java.io.*;

public class Boj1644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] sieve = new boolean[4_000_001];
    static int[] primes = new int[4_000_001];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= 4_000_000; i++) {
            int t = 2;
            while (i * t <= 4_000_000) {
                sieve[i * t] = true;
                t++;
            }
        }

        int idx = 0;
        for (int i = 2; i <= 4_000_000; i++) {
            if (!sieve[i]) {
                primes[idx] = i;
                idx++;
            }
        }

        int left = 0, right = 0;
        int sum = 2;
        int cnt = 0;
        while (left <= idx && right <= idx) {
            if (sum < n) {
                right++;
                sum += primes[right];
            }
            if (sum > n) {
                sum -= primes[left];
                left++;
            }
            if (sum == n) {
                cnt++;
                sum -= primes[left];
                left++;
            }
        }

        System.out.println(cnt);
    }

}
