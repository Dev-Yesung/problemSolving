package baekjoon;

// 산술평균 : sum / cnt
// 중앙값 : 정렬 -> 중앙에 있는 값
// 최빈값 : 가장 많은 빈도로 나타나는 값
// 범위 : 최댓값과 최솟값의 차이

// 모든 수의 합이 가장 클 때는 20억 -> int 범위에서 해결 가능

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Boj2108 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // n은 홀수
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        int[] freq = new int[8001];
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            numbers[i] = val;
            freq[val + 4000]++;
        }
        Arrays.sort(numbers);

        // 산술평균
        double sum = (double) Arrays.stream(numbers).sum() / n;
        int avg = (int) Math.round(sum);

        // 중앙값
        int midVal = numbers[n / 2];

        // 최빈값 후보 찾기
        int cnt = Arrays.stream(freq).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 8001)
                .filter(idx -> freq[idx] == cnt)
                .forEach(idx -> list.add(idx - 4000));

        int freqVal;
        if (list.size() > 1) {
            list.sort((a, b) -> a - b);
            freqVal = list.get(1);
        } else {
            freqVal = list.get(0);
        }

        // 범위
        int range = numbers[n - 1] - numbers[0];

        System.out.printf("%d\n%d\n%d\n%d\n", avg, midVal, freqVal, range);
    }
}
