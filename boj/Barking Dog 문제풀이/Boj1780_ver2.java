package ps;

import java.io.*;
import java.util.*;

public class Boj1780_ver2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board = new int[2200][2200];
    static int[] cnt = new int[3];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, n);

        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }

    static void solution(int row, int col, int n) {
        if (check(row, col, n)) {
            // 크기가 1일 때나, 모든 행렬이 같은 값으로 채워졌을 때,
            // 이런 식으로 코드를 합쳐서 표현할 수 있다.
            cnt[board[row][col] + 1]++;
            return;
        }

        // 총 9개의 recursion 함수를 부르는 방식을 이런 식으로 일반화해서 표현할 수 있음
        // length 정보(변수 third)와 시작 index(row와 col)만을 가지고 계산을 하면 된다.
        int third = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution(row + i * third, col + j * third, third);
            }
        }
    }

    static boolean check(int row, int col, int n) {
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                // 행렬의 첫 번째 원소를 고정시켜놓고 같은지 다른지만 체크하면 된다.
                if (board[row][col] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
