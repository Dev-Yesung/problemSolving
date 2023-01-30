package ps;

import java.io.*;
import java.util.*;

public class Boj2630 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] paper = new int[128][128];
    static int[] result = new int[2];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, n);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static void solution(int row, int col, int n) {
        if (isNotDifferent(row, col, n)) {
            result[paper[row][col]]++;
            return;
        }

        int div = n / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solution(row + i * div, col + j * div, div);
            }
        }
    }

    static boolean isNotDifferent(int row, int col, int n) {
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (paper[row][col] != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
