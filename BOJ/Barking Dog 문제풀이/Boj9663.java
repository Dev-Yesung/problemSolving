package ps;

import java.io.*;
import java.util.*;

/*
    base condition 을 찾는거나 recursion 을 만드는 것 자체는 쉬웠으나
    대각선 방향 체크나 가지 못하는 위치를 체크하는 부분의 구현에서 어려움을 겪었음
    특히 퀸이 놓인 위치에서 오른쪽 대각선 방향을 체크하는데 어려움을 겪었다.
    이 부분에 대해서는 아이디어를 기억해 놓자.
 */
public class Boj9663 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] isMoved1 = new boolean[30];
    static boolean[] isMoved2 = new boolean[30];
    static boolean[] isMoved3 = new boolean[30];
    static int count = 0;
    static int N;

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
            if (isMoved1[col] || isMoved2[row + col] || isMoved3[N + row - col - 1]) {
                continue;
            }
            isMoved1[col] = true;
            isMoved2[row + col] = true;
            isMoved3[N + row - col - 1] = true;
            solution(row + 1);
            isMoved1[col] = false;
            isMoved2[row + col] = false;
            isMoved3[N + row - col - 1] = false;
        }
    }
}
