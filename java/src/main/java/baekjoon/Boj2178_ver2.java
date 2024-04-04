package baekjoon;

import java.io.*;
import java.util.*;

public class Boj2178_ver2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map = new int[102][102];
    static int[][] dist = new int[102][102];
    static Queue<Pair<Integer, Integer>> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        String size = br.readLine();
        StringTokenizer st = new StringTokenizer(size, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(line[j-1]);
            }
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], 1, M + 1, -1);
        }

        dist[1][1] = 1;
        q.add(new Pair<>(1, 1));
        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];

                if (nx < 1 || nx > N || ny < 1 || ny > M) {
                    continue;
                }
                if (map[nx][ny] != 1 || dist[nx][ny] >= 0) {
                    continue;
                }

                dist[nx][ny] = dist[cur.X][cur.Y] + 1;
                q.add(new Pair<>(nx, ny));
            }
        }

        System.out.println(dist[N][M]);
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
