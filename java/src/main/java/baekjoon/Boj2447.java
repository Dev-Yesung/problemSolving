package baekjoon;

import java.io.*;
import java.util.*;

public class Boj2447 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static char[][] pattern = new char[6561][6561];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Arrays.fill(pattern[i], 0, n, ' ');
        }

        solution(0, 0, n);
        print(n);
    }

    static void solution(int row, int col, int n) {
        // 베이스 컨디션을 3이 아닌 1로 잡아서 조건에 맞는 그 위치에 별을 찍음
        if (n == 1) {
            pattern[row][col] = '*';
            return;
        }

        int third = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 애초에 전체적인 루프에서 가운데 부분에 진입하지 않게 만들면 됨
                if (i == 1 && j == 1) {
                    continue;
                }
                solution(row + i * third, col + j * third, third);
            }
        }
    }

    static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
