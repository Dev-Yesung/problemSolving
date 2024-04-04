package baekjoon;

import java.io.*;
import java.util.*;

// DP 연습 문제
// 재귀로 만들 수는 있으나 n의 값이 300이기 때문에 백트레킹은 불가능하다 -> O(2^300)이므로 말도 안되게 크다.
// DP로 풀 때 그리디로 풀면 왜 안되는 지 생각하면서 풀기
// 구현력 딸림
// 여러가지 풀이 방법이 있으니 모두 익히도록 한다.
public class Boj2579 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] stair = new int[305];
    static int[][] total = new int[305][3];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stair[1]);
            return;
        }

        // 계산을 편하게 하기 위해 초기값을 이렇게 세팅함
        total[1][1] = stair[1];
        total[2][1] = stair[2];
        total[2][2] = stair[1] + stair[2];
        for (int i = 3; i <= n; i++) {
            // 점화식을 세웠던 방식을 기억해서 다시 해보자
            total[i][1] = Integer.max(total[i - 2][1], total[i - 2][2]) + stair[i];
            total[i][2] = total[i - 1][1] + stair[i];
        }

        System.out.println(Integer.max(total[n][1], total[n][2]));
    }
}
