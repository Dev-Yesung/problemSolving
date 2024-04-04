package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] display = new int[64][64];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(String.valueOf(line.charAt(j)));
                display[i][j] = num;
            }
        }

        solution(0, 0, n);
        System.out.println(sb);
    }

    static void solution(int r, int c, int n) {
        if (isNotDiff(r, c, n)) {
            sb.append(display[r][c]);
            return;
        }

        sb.append('(');
        int div = n / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solution(r + i * div, c + j * div, div);
            }
        }
        sb.append(')');
    }

    static boolean isNotDiff(int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (display[r][c] != display[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
