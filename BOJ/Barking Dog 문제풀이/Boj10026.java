package ps;

import java.io.*;
import java.util.*;

public class Boj10026 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Pair<Integer, Integer>> q = new LinkedList<>();
    static char[][] display = new char[102][102];
    static boolean[][] vis = new boolean[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] able = new int[3];
    static int[] disable = new int[2];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= n; j++) {
                display[i][j] = line.charAt(j - 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!vis[i][j]) {
                    vis[i][j] = true;

                    if (display[i][j] == 'R') {
                        able[0]++;
                    } else if (display[i][j] == 'G') {
                        able[1]++;
                    } else if (display[i][j] == 'B') {
                        able[2]++;
                    }

                    q.add(new Pair<>(i, j, display[i][j]));
                    while (!q.isEmpty()) {
                        Pair<Integer, Integer> cur = q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.X + dx[dir];
                            int ny = cur.Y + dy[dir];

                            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                                continue;
                            }
                            if (display[nx][ny] != cur.type || vis[nx][ny]) {
                                continue;
                            }

                            vis[nx][ny] = true;
                            q.add(new Pair<>(nx, ny, cur.type));
                        }
                    }
                }
            }
        }

        q.clear();
        vis = new boolean[102][102];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!vis[i][j]) {
                    vis[i][j] = true;

                    if (display[i][j] == 'R' || display[i][j] == 'G') {
                        disable[0]++;
                    } else if (display[i][j] == 'B') {
                        disable[1]++;
                    }

                    q.add(new Pair<>(i, j, display[i][j]));
                    while (!q.isEmpty()) {
                        Pair<Integer, Integer> cur = q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.X + dx[dir];
                            int ny = cur.Y + dy[dir];

                            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                                continue;
                            }
                            if (cur.type == 'R' && display[nx][ny] == 'B') {
                                continue;
                            }
                            if (cur.type == 'G' && display[nx][ny] == 'B') {
                                continue;
                            }
                            if (cur.type == 'B' && display[nx][ny] != cur.type) {
                                continue;
                            }
                            if (vis[nx][ny]) {
                                continue;
                            }

                            vis[nx][ny] = true;
                            q.add(new Pair<>(nx, ny, cur.type));
                        }
                    }
                }
            }
        }

        int ableTotal = Arrays.stream(able).reduce(0, Integer::sum);
        int disableTotal = Arrays.stream(disable).reduce(0, Integer::sum);
        System.out.println(ableTotal + " " + disableTotal);
    }

    static class Pair<L, R> {

        L X;
        R Y;
        char type;

        Pair(L X, R Y, char type) {
            this.X = X;
            this.Y = Y;
            this.type = type;
        }
    }

}
