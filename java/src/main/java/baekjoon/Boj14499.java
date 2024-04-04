package baekjoon;

import java.io.*;
import java.util.*;

public class Boj14499 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static int[][] map;
    static int n, m, x, y, k;
    static int[] dice = new int[7];
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        String[] params = br.readLine().split(" ");
        n = parseInt(params[0]);
        m = parseInt(params[1]);
        x = parseInt(params[2]);
        y = parseInt(params[3]);
        k = parseInt(params[4]);

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            params = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = parseInt(params[j]);
            }
        }

        params = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int dir = parseInt(params[i]);
            move(dir);
        }

        System.out.println(answer);
    }

    static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    static void move(int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            return;
        }

        roll(dir, nx, ny);
        x = nx;
        y = ny;
    }

    static void roll(int dir, int x, int y) {
        int tmp;
        // 동쪽
        if (dir == 1) {
            tmp = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = tmp;
        }
        // 서쪽
        if (dir == 2) {
            tmp = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = tmp;
        }
        // 북쪽
        if (dir == 3) {
            tmp = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = tmp;
        }
        // 남쪽
        if (dir == 4) {
            tmp = dice[6];
            dice[6] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[2];
            dice[2] = tmp;
        }

        if (map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

        answer.append(dice[1])
                .append('\n');
    }
}
