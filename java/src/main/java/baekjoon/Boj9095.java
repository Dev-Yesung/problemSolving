package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 1. 테이블 정의하기 > D[i]는 숫자 i를 1,2,3의 합으로 나타내는 방법의 수
 * 2. 점화식 찾기
 * > D[i]의 개수는 D[i-1], D[i-2], D[i-3]에서 구한 방법의 개수를 모두 합한 값이다.
 * > 왜냐하면, i에서 1작은 값에서 나온 방법에 +1만 해주는 방법, 2작은 값에서 나온 방법에 +2만 해주는 방법
 * > 3작은 값에서 나온 방법에 +3만 해주는 방법을 모두 합하면 1,2,3의 합으로 나타내는 모든 방법의 수가 나온다.
 */
public class Boj9095 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        dp[0] = 1;
        for (int i = 1; i < 11; i++) {
            dp[i] += dp[i - 1];
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
            if (i - 3 >= 0) {
                dp[i] += dp[i - 3];
            }
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
