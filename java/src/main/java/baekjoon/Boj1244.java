package baekjoon;

import java.io.*;

public class Boj1244 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean[] state = new boolean[101];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (line[i].equals("0")) {
                state[i + 1] = false;
                continue;
            }
            state[i + 1] = true;
        }

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            line = br.readLine().split(" ");
            int idx = Integer.parseInt(line[1]);

            // 남자인 경우
            if (line[0].equals("1")) {
                for (int j = 1; idx * j <= n; j++) {
                    state[idx * j] = !state[idx * j];
                }
            }
            // 여자인 경우
            if (line[0].equals("2")) {
                state[idx] = !state[idx];

                int len = Math.min(idx - 1, n - idx);
                int t = 0;
                for (int j = 1; j <= len; j++) {
                    boolean leftState = state[idx - j];
                    boolean rightState = state[idx + j];

                    if (leftState != rightState) {
                        break;
                    }
                    t++;
                }
                // 왼쪽을 바꿈
                for (int j = idx - t; j < idx; j++) {
                    state[j] = !state[j];
                }
                // 오른쪽을 바꿈
                for (int j = idx + 1; j <= idx + t; j++) {
                    state[j] = !state[j];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (state[i]) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.print(sb);
    }
}
