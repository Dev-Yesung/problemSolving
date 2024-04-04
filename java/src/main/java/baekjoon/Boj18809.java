package baekjoon;

import java.io.*;
import java.util.*;

public class Boj18809 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int m = Integer.parseInt(param[1]);
        int g = Integer.parseInt(param[2]);
        int r = Integer.parseInt(param[3]);

        int[][] map = new int[n][m];
        List<Pos> possible = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 2) {
                    possible.add(new Pos(i, j));
                }
            }
        }



    }

    static class Pos {
        int x;
        int y;
        int t;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
            this.t = 0;
        }
    }

    static class Water {
        int x;
        int y;
        boolean isRed;

        public Water(int x, int y, boolean isRed) {
            this.x = x;
            this.y = y;
            this.isRed = isRed;
        }
    }
}
