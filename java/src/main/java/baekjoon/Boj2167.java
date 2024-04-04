package baekjoon;

import java.io.*;
import java.util.*;

public class Boj2167 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int m = Integer.parseInt(param[1]);

        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            param = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(param[j - 1]);
            }
        }

    }
}
