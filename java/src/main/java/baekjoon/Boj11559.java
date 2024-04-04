package baekjoon;

import java.io.*;
import java.util.*;

public class Boj11559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][] map;
    static boolean[][] vis;
    static List<Pos> list;
    static int n = 12, m = 6;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        map = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j];
            }
        }

        int cnt = 0;
        while (true) {
            boolean isFinished = true;
            vis = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!map[i][j].equals(".")) {
                        list = new ArrayList<>();
                        bfs(i, j);

                        if (list.size() >= 4) {
                            isFinished = false;
                            for (int k = 0; k < list.size(); k++) {
                                map[list.get(k).x][list.get(k).y] = ".";
                            }
                        }
                    }
                }
            }

            if (isFinished) {
                break;
            }
            reArrange();
            cnt++;
        }

        System.out.println(cnt);
    }

    private static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        Pos pos = new Pos(x, y);
        list.add(pos);
        q.offer(pos);
        vis[x][y] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (!map[nx][ny].equals(map[x][y]) || vis[nx][ny]) {
                    continue;
                }

                Pos newPos = new Pos(nx, ny);
                vis[nx][ny] = true;
                list.add(newPos);
                q.offer(newPos);
            }
        }
    }

    private static void reArrange() {
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j > 0; j--) {
                if (map[j][i].equals(".")) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (!map[k][i].equals(".")) {
                            map[j][i] = map[k][i];
                            map[k][i] = ".";
                            break;
                        }
                    }
                }
            }
        }
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
