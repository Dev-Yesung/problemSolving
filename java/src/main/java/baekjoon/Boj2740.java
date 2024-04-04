package baekjoon;

import java.io.*;

public class Boj2740 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int m = Integer.parseInt(param[1]);

        int[][] m1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                m1[i][j] = Integer.parseInt(line[j]);
            }
        }

        param = br.readLine().split(" ");
        int k = Integer.parseInt(param[1]);

        int[][] m2 = new int[m][k];
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                m2[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] result = new int[n][k];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < k; c++) {
                for (int mul = 0; mul < m; mul++) {
                    result[r][c] += m1[r][mul] * m2[mul][c];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
