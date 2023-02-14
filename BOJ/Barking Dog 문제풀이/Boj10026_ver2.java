package ps;

import java.io.*;
import java.util.*;

public class Boj10026_ver2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] display = new char[102][102];
    static boolean[][] vis = new boolean[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= n; j++) {
                display[i][j] = line.charAt(j - 1);
            }
        }

        int able = countArea();
        for (int i = 1; i <= n; i++) {
            Arrays.fill(vis[i], 1, 1 + n, false);
        }
        // 굳이 중복된 bfs코드를 만들 필요 없이 R을 G로 혹은 그 반대로 바꿔서 bfs하면 똑같다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (display[i][j] == 'G') {
                    display[i][j] = 'R';
                }
            }
        }
        int disable = countArea();

        System.out.println(able + " " + disable);
    }

    // 구역 값을 따로 계산해서 저장해놔도 되지만 이렇게 리턴하는 함수로 만들면 편할거 같다.
    static int countArea() {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!vis[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }
        return count;
    }

    static void bfs(int posX, int posY) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        vis[posX][posY] = true;
        q.add(new Pair<>(posX, posY));

        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];

                if (nx < 1 || nx > n || ny < 1 || ny > n) {
                    continue;
                }
                if (display[nx][ny] != display[cur.X][cur.Y] || vis[nx][ny]) {
                    continue;
                }

                vis[nx][ny] = true;
                q.add(new Pair<>(nx, ny));
            }
        }
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
