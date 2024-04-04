package baekjoon;

import java.io.*;
import java.util.*;

public class Boj18869 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int m = Integer.parseInt(param[0]);
        int n = Integer.parseInt(param[1]);

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }


    }
}
