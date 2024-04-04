package baekjoon;

import java.io.*;
import java.util.*;

// 성능 최적화를 위해서는 점프하는 방법으로 구현해야하지만, 그냥 하나씩 옮겨도 상관없음 -> 시간초과 안됨
// 모서리 부분에서 방향을 바꿔줘야한다.
// 사각형의 가로 혹은 세로 둘 중 하나는 무조건 짝수이다.
// 케이스 by 케이스로 나눠서 처리하자.
// ex) 가로, 세로 모두 짝수 | 가로 짝수, 세로 홀수 | 가로 홀수, 세로 짝수

public class Boj16926 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int m = Integer.parseInt(param[1]);
        int r = Integer.parseInt(param[2]);

        int[][] matrix = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            param = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = Integer.parseInt(param[j - 1]);
            }
        }

        for (int cnt = 0; cnt < r; cnt++) {

        }
    }


}
