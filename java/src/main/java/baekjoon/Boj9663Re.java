package baekjoon;

import java.io.*;

public class Boj9663Re {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] map;
    static boolean[][] isVisited;
    static int count;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];

        recursion(0);
        System.out.println(count);
    }

    static void recursion(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isVisited[row][col]) {
                check(row, col);
                recursion(row + 1);
                uncheck(row, col);
                remark();
            }
        }
    }

    static void remark() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    check(i, j);
                }
            }
        }
    }

    static void check(int row, int col) {
        map[row][col] = 1;
        isVisited[row][col] = true;

        for (int nxt = row; nxt < n; nxt++) {
            isVisited[nxt][col] = true;
        }

        int nxtR = row + 1;
        int nxtC = col + 1;
        while (nxtR < n && nxtC < n) {
            isVisited[nxtR][nxtC] = true;
            nxtR++;
            nxtC++;
        }

        nxtR = row + 1;
        nxtC = col - 1;
        while (nxtR < n && nxtC >= 0) {
            isVisited[nxtR][nxtC] = true;
            nxtR++;
            nxtC--;
        }
    }

    static void uncheck(int row, int col) {
        map[row][col] = 0;
        isVisited[row][col] = false;

        for (int nxt = row; nxt < n; nxt++) {
            isVisited[nxt][col] = false;
        }

        int nxtR = row + 1;
        int nxtC = col + 1;
        while (nxtR < n && nxtC < n) {
            isVisited[nxtR][nxtC] = false;
            nxtR++;
            nxtC++;
        }

        nxtR = row + 1;
        nxtC = col - 1;
        while (nxtR < n && nxtC >= 0) {
            isVisited[nxtR][nxtC] = false;
            nxtR++;
            nxtC--;
        }
    }


}
