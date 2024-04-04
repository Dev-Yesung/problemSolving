package baekjoon;

import java.io.*;
import java.util.*;


// 시간초과 -> 큐나 리스트 써서 났었음
// 틀렸습니다 -> total 을 1로 설정하고 처음부터 루프를 돌려서 틀렸었음
// 왜냐하면 1->2로 시작하는 경우는 괜찮은데 1->1로 시작하면 2번 체크됨
// https://st-lab.tistory.com/145
public class Boj1931 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            list[i][0] = x;
            list[i][1] = y;
        }
        Arrays.sort(list, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int end = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (end <= list[i][0]) {
                end = list[i][1];
                total++;
            }
        }

        System.out.println(total);
    }
}
