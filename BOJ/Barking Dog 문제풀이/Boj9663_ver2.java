package ps;

import java.io.*;
import java.util.*;

/*
    https://st-lab.tistory.com/118 참고
    이 풀이 방식은 처음 풀이보다 좀 더 간단한 방식이다.
    대각선 방향을 찾아야 하는 것은 동일하지만 계산 방법이 더 단순
    또한 놓을 수 없는 위치를 표시하는 것도 배열 하나면 충분하다.
    핵심은 대각선에 놓을 수 없는 위치를 찾을 때,
    행의 차의 절대값과 열의 차의 절대값이 같은 부분이 된다는 것이다.
    이 부분이 이해하기 어려웠으나 천천히 수학적인 방식으로 생각해보니 이해가 됐다.
 */
public class Boj9663_ver2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] board;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N];

        solution(0);

        System.out.println(count);
    }

    static void solution(int col) {
        if (col == N) {
            count++;
            return;
        }

        for (int row = 0; row < N; row++) {
            board[col] = row;
            if (isPossible(col)) {
                solution(col + 1);
            }
        }
    }

    static boolean isPossible(int cur) {
        for (int col = 0; col < cur; col++) {
            if (board[cur] == board[col]) {
                return false;
            }
            if (cur - col == Math.abs(board[cur] - board[col])) {
                return false;
            }
        }
        return true;
    }
}
