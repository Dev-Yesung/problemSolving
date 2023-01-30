package ps;

import java.io.*;
import java.util.*;

public class Boj1780 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int minusOne = 0, zero = 0, plusOne = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        board = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");

            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        solution(1, 1, n);

        sb.append(minusOne).append('\n')
          .append(zero).append('\n')
          .append(plusOne);
        System.out.println(sb);
    }

    static void solution(int row, int col, int length) {
        if (length == 1) {
            addResult(row, col);
            return;
        }

        if (isDifferent(row, col, length)) {
            int third = length / 3;
            solution(row, col, third);
            solution(row, col + third, third);
            solution(row, col + 2 * third, third);

            solution(row + third, col, third);
            solution(row + third, col + third, third);
            solution(row + third, col + 2 * third, third);

            solution(row + 2 * third, col, third);
            solution(row + 2 * third, col + third, third);
            solution(row + 2 * third, col + 2 * third, third);
        } else {
            addResult(row, col);
        }
    }

    static boolean isDifferent(int row, int col, int length) {
        int elem = board[row][col];
        boolean flag = false;

        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (elem != board[i][j]) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }
        return flag;
    }

    static void addResult(int row, int col) {
        if (board[row][col] == -1) {
            minusOne++;
        } else if (board[row][col] == 0) {
            zero++;
        } else if (board[row][col] == 1) {
            plusOne++;
        }
    }
}
