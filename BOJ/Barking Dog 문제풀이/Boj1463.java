package ps;

import java.io.*;
import java.util.*;

// DP로 해결해본 후 BFS로 해결해보도록 하자.

/**
 *  문제를 푸는 과정
 *  1. 테이블 정의하기 > "D[i]의 값은 i를 1로 만들기 위해 필요한 연산 사용 횟수의 최솟값"
 *  2. 점화식 찾기 > 작은 값부터 최소한의 연산 횟수를 찾아서 부분최적화 값을 더해간다.
 *  ✕. DP 에서 매번 점화식이 돌아갈 수 있게 하기 위한 초기값이 어디까지인지를 고민해서 초기값을 적용해야 한다.
 */
public class Boj1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] cnt = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= N; i++) {
            cnt[i] = cnt[i - 1] + 1;
            if (i % 3 == 0) {
                cnt[i] = Math.min(cnt[i], cnt[i / 3] + 1);
            }
            if (i % 2 == 0) {
                cnt[i] = Math.min(cnt[i], cnt[i / 2] + 1);
            }
        }

        System.out.println(cnt[N]);
    }
}
