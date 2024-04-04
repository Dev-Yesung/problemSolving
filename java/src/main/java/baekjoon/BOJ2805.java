package baekjoon;

import java.io.*;
import java.util.*;

// https://st-lab.tistory.com/270
// lower bound 와 upper bound 의 개념을 다시 숙지하자.
// 좀만 더 노력해서 이해하고 여러번 풀어보자
// 파라메트릭 서치의 개념을 이용해서 그래프를 그려보자
// 이 문제는 최적화 즉, h의 최대값(잘린 나무 길이 합의 최소값)을 구하는 문제
// 이 문제를 이분탐색법을 통해 높이가 h일때 나무 길이의 합이 M이상인가 아닌가(결정문제)
public class Boj2805 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] params = br.readLine().split(" ");
        int[] arr = Arrays.stream(params).mapToInt(Integer::valueOf).toArray();

        int lo = 0;
        int hi = Arrays.stream(arr).max().getAsInt();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            long sum = Arrays.stream(arr)
                             .mapToLong(Long::valueOf)
                             .filter(elem -> elem > mid)
                             .reduce(0, (a, b) -> a + b - mid);
            if (sum < m) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(hi - 1);
    }
}
