package baekjoon;

import java.io.*;
import java.util.*;

public class Boj7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][][] board = new int[101][101][101];
    static int[][][] dist = new int[101][101][101];
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int m = Integer.parseInt(param[0]);
        int n = Integer.parseInt(param[1]);
        int h = Integer.parseInt(param[2]);

        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String[] line = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    int val = Integer.parseInt(line[k]);
                    board[j][k][i] = val;
                    if (val == 1) {
                        q.offer(new Pos(j, k, i));
                    }
                    if (val == 0) {
                        dist[j][k][i] = -1;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curZ = cur.z;

            for (int dir = 0; dir < 6; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                int nz = curZ + dz[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) {
                    continue;
                }
                if (dist[nx][ny][nz] >= 0) {
                    continue;
                }

                dist[nx][ny][nz] = dist[curX][curY][curZ] + 1;
                q.offer(new Pos(nx, ny, nz));
            }
        }

        int answer = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (dist[j][k][i] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, dist[j][k][i]);
                }
            }
        }

        System.out.println(answer);
    }

    static class Pos {
        int x;
        int y;
        int z;

        Pos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
