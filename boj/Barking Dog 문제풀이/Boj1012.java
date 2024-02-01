package ps;

import java.io.*;
import java.util.*;

public class Boj1012 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int[][] field = new int[50][50];
            boolean[][] vis = new boolean[50][50];
            int counter = 0;
            Queue<Pair<Integer, Integer>> q = new LinkedList<>();

            String[] params = br.readLine().split(" ");
            int M = Integer.parseInt(params[0]);
            int N = Integer.parseInt(params[1]);
            int K = Integer.parseInt(params[2]);

            for (int cnt = 0; cnt < K; cnt++) {
                String[] elem = br.readLine().split(" ");
                int x = Integer.parseInt(elem[0]);
                int y = Integer.parseInt(elem[1]);

                field[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !vis[i][j]) {
                        counter++;
                        vis[i][j] = true;
                        q.add(new Pair<>(i, j));
                        while (!q.isEmpty()) {
                            Pair<Integer, Integer> cur = q.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nx = cur.X + dx[dir];
                                int ny = cur.Y + dy[dir];

                                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                                    continue;
                                }
                                if (field[nx][ny] != 1 || vis[nx][ny]) {
                                    continue;
                                }

                                vis[nx][ny] = true;
                                q.add(new Pair<>(nx, ny));
                            }
                        }
                    }
                }
            }
            sb.append(counter).append('\n');
        }

        System.out.println(sb);
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
