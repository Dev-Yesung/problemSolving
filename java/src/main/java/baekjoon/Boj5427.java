package baekjoon;

import java.io.*;
import java.util.*;

public class Boj5427 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int cnt = 0; cnt < tc; cnt++) {
            String[] param = br.readLine().split(" ");
            int w = Integer.parseInt(param[0]);
            int h = Integer.parseInt(param[1]);

            int[][] board = new int[h][w];
            int[][] visF = new int[h][w];
            int[][] visP = new int[h][w];
            Queue<Pos> pq = new LinkedList<>();
            Queue<Pos> fq = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                String[] line = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    if (line[j].equals("#")) {
                        board[i][j] = -1;
                    }
                    if (line[j].equals("@")) {
                        pq.offer(new Pos(i, j));
                        visP[i][j] = 1;
                    }
                    if (line[j].equals("*")) {
                        fq.offer(new Pos(i, j));
                        visF[i][j] = 1;
                    }
                }
            }

            while (!fq.isEmpty()) {
                Pos cur = fq.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        continue;
                    }
                    if (board[nx][ny] == -1) {
                        continue;
                    }
                    if (visF[nx][ny] > 0) {
                        continue;
                    }

                    visF[nx][ny] = visF[cur.x][cur.y] + 1;
                    fq.offer(new Pos(nx, ny));
                }
            }

            boolean isFinish = false;
            while (!pq.isEmpty() && !isFinish) {
                Pos cur = pq.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        sb.append(visP[cur.x][cur.y]);
                        isFinish = true;
                        break;
                    }
                    if (board[nx][ny] == -1) {
                        continue;
                    }
                    if (visP[nx][ny] > 0) {
                        continue;
                    }
                    if (visF[nx][ny] != 0 && (visF[nx][ny] <= visP[cur.x][cur.y] + 1)) {
                        continue;
                    }

                    visP[nx][ny] = visP[cur.x][cur.y] + 1;
                    pq.offer(new Pos(nx, ny));
                }
            }

            if (!isFinish) {
                sb.append("IMPOSSIBLE");
            }
            sb.append('\n');
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
