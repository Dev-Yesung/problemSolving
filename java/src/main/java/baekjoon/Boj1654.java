package baekjoon;

import java.io.*;
import java.util.*;

/*
    parametric search
    1) 만일 1 ~ 랜선 중 길이가 가장 긴 값까지 파라미터 범위 설정
    2) 이분탐색 진행
    3) if sum < N -> hi = mid, if sum >= N -> lo = mid + 1
    4) 결과값은 lo - 1의 값
    sum값은 long으로 잡기
 */

public class Boj1654 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] params = br.readLine().split(" ");
        int k = Integer.parseInt(params[0]);
        int n = Integer.parseInt(params[1]);

        int[] wires = new int[k];
        for (int i = 0; i < k; i++) {
            wires[i] = Integer.parseInt(br.readLine());
        }
//        int MAX = Arrays.stream(wires).max().getAsInt();

        long lo = 1, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            long sum = Arrays.stream(wires)
                             .mapToLong(wire -> (long) wire / mid)
                             .sum();

            if (sum < n) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        System.out.println(lo);
    }
}
