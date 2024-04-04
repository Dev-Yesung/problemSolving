package baekjoon;

import java.io.*;
import java.util.*;

/*
    내가 가장 초기에 생각했던 풀이 방법이다.
    처음에는 vis 배열만 만들어서 백트래킹을 하면 될줄 알았는데,
    생각해보니 백트래킹 하는 중에 리턴되어 돌아올 때 vis 를 true 로 체크했던 부분 중
    이전에 true 로 체크했던 부분도 false 로 바꿔놓는 논리의 오류가 발생하게 되었다.
    결국 이 방법을 사용하려면 백트래킹하면서 노가다로 다시 들어가면 안되는 위치를 설정해야한다.
    상당히 번거로운 방법이기 때문에 구현 연습용으로만 남겨두었다.
 */

public class Boj9663_ver3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board = new int[14][14];
    static boolean[][] vis = new boolean[14][14];
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        solution(0);
        System.out.println(count);
    }

    static void solution(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!vis[row][col]) {
                check(row, col);
                solution(row + 1);
                uncheck(row, col);
                restore();
            }
        }
    }

    static void check(int curRow, int curCol) {
        // 현재 퀸의 위치 표시
        board[curRow][curCol] = 1;
        vis[curRow][curCol] = true;

        // 세로라인 true 체크하기
        for (int r = curRow; r < N; r++) {
            vis[r][curCol] = true;
        }
        // 오른쪽 대각선라인 true 체크하기
        int r = curRow + 1, c = curCol + 1;
        while (r < N && c < N) {
            vis[r][c] = true;
            r++;
            c++;
        }
        // 왼쪽 대각선 라인 true 체크하기
        r = curRow + 1;
        c = curCol - 1;
        while (r < N && c >= 0) {
            vis[r][c] = true;
            r++;
            c--;
        }
    }

    static void uncheck(int curRow, int curCol) {
        // 현재 퀸의 위치 표시풀기
        board[curRow][curCol] = 0;
        vis[curRow][curCol] = false;

        // 세로라인 false 체크하기
        for (int r = curRow; r < N; r++) {
            vis[r][curCol] = false;
        }
        // 오른쪽 대각선라인 false 체크하기
        int r = curRow + 1, c = curCol + 1;
        while (r < N && c < N) {
            vis[r][c] = false;
            r++;
            c++;
        }
        // 왼쪽 대각선 라인 false 체크하기
        r = curRow + 1;
        c = curCol - 1;
        while (r < N && c >= 0) {
            vis[r][c] = false;
            r++;
            c--;
        }
    }

    static void restore() {
        // 복구 안된 부분 복구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    check(i, j);
                }
            }
        }
    }
}
