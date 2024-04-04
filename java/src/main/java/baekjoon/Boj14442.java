package baekjoon;

import java.io.*;
import java.util.*;

public class Boj14442 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static boolean[][][] isVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);

        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            line = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                int elem = Integer.parseInt(line[j - 1]);
                map[i][j] = elem;
            }
        }

        isVisited = new boolean[n + 1][m + 1][k + 1];
        isVisited[1][1][0] = true;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(1, 1, 1, 0));
        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (cur.x == n && cur.y == m) {
                ans = Math.min(ans, cur.dist);
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    if (cur.cnt < k && !isVisited[nx][ny][cur.cnt + 1]) {
                        isVisited[nx][ny][cur.cnt + 1] = true;
                        q.offer(new Pos(nx, ny, cur.dist + 1, cur.cnt + 1));
                    }
                } else {
                    if (!isVisited[nx][ny][cur.cnt]) {
                        isVisited[nx][ny][cur.cnt] = true;
                        q.offer(new Pos(nx, ny, cur.dist + 1, cur.cnt));
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

    static class Pos {
        int x;
        int y;
        int dist;
        int cnt;

        Pos(int x, int y, int dist, int cnt) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.cnt = cnt;
        }
    }
}
