package baekjoon;

import java.io.*;
import java.util.*;

/**
 * distance 배열을 이용하는 아이디어를 기억하자! -> 이 방식을 통해 하루에 익게해야할 토마토를 모두 큐에 넣는 방식을 사용안해도 된다!
 */
public class Boj7576_ver2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Pair<Integer, Integer>> q = new LinkedList<>();
    static int[][] container = new int[1002][1002];
    static int[][] dist = new int[1002][1002];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        String size = br.readLine();
        StringTokenizer st = new StringTokenizer(size, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= M; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line, " ");
            for (int j = 1; j <= N; j++) {
                int status = Integer.parseInt(st.nextToken());
                container[i][j] = status;
                if (status == 1) {
                    q.add(new Pair<>(i, j));
                }
                if (container[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];

                if (nx < 1 || nx > M || ny < 1 || ny > N) {
                    continue;
                }
                if (dist[nx][ny] >= 0) {
                    continue;
                }

                dist[nx][ny] = dist[cur.X][cur.Y] + 1;
                q.add(new Pair<>(nx, ny));
            }
        }

        int ans = 0;
        boolean isFail = false;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == -1) {
                    isFail = true;
                    ans = -1;
                    break;
                }
                ans = Integer.max(ans, dist[i][j]);
            }

            if (isFail) {
                break;
            }
        }
        System.out.println(ans);
    }

    static class Pair<L, R> {

        L X;
        R Y;

        Pair(L X, R Y) {
            this.X = X;
            this.Y = Y;
        }
    }
}
