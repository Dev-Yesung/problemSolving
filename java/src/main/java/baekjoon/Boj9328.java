package baekjoon;

import java.io.*;
import java.util.*;

public class Boj9328 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[][][] map;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] param = br.readLine().split(" ");
            int h = Integer.parseInt(param[0]);
            int w = Integer.parseInt(param[1]);

            map = new String[h][w][3];
            for (int i = 0; i < h; i++) {
                String[] line = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    map[i][j][0] = line[j];
                }
            }
        }
    }
}
