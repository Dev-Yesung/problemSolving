package ps;

import java.io.*;
import java.util.*;


/*
    재귀적 풀이를 연습할 때 종종 풀어보자!!
    재귀 풀이의 기본적인 아이디어는 N-1에서 풀었던 방법을 N에서 이용할 수 있다는 것이다.
 */
public class Boj1074 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        System.out.println(solution(n, r, c));
    }

    static int solution(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = 1 << (n - 1);
        if (r < half && c < half) {
            return 0 * half * half + solution(n - 1, r, c);
        }
        if (r < half && c >= half) {
            return 1 * half * half + solution(n - 1, r, c - half);
        }
        if (r >= half && c < half) {
            return 2 * half * half + solution(n - 1, r - half, c);
        }
        return 3 * half * half + solution(n - 1, r - half, c - half);
    }
}
