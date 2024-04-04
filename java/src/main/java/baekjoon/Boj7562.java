package baekjoon;

import java.io.*;
import java.util.*;

public class Boj7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            Queue<Pos> q = new LinkedList<>();
            int l = Integer.parseInt(br.readLine());
            int[][] dist = new int[l][l];

            String[] line = br.readLine().split(" ");
            int stX = Integer.parseInt(line[0]);
            int stY = Integer.parseInt(line[1]);

            line = br.readLine().split(" ");
            int finX = Integer.parseInt(line[0]);
            int finY = Integer.parseInt(line[1]);

            if (stX == finX && stY == finY) {
                sb.append(dist[finX][finY])
                        .append('\n');
                continue;
            }

            q.offer(new Pos(stX, stY));
            boolean isFin = false;
            while (!q.isEmpty()) {
                Pos cur = q.poll();

                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || nx >= l || ny < 0 || ny >= l) {
                        continue;
                    }
                    if (dist[nx][ny] > 0) {
                        continue;
                    }

                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    if (nx == finX && ny == finY) {
                        isFin = true;
                        break;
                    }
                    q.offer(new Pos(nx, ny));
                }

                if (isFin) {
                    break;
                }
            }

            sb.append(dist[finX][finY])
                    .append('\n');
        }

        System.out.print(sb);
    }

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
