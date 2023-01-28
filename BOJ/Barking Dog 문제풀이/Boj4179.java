package ps;

import java.io.*;
import java.util.*;

// 다시풀어보기!!
/*
 * 문제점 1. 메모리초과 > 메모리 초과가 나는 이유는 BFS를 두 번 돌렸기 때문이다.
 * 두 번의 BFS에서 사용하는 큐에 너무 많은 객체들이 들어가서 메모리 초과가 날 수 있다.
 * > 해결 방법 찾음 : 이동거리를 기준으로하는 배열을 이용하면 다른 기준의 이동에 대해서도 같은 방식을 이용할 수 있다.
 * > 백준 토마토 문제 참고!!
 *
 * 문제점 2. 즉시 탈출 할 수 있는 경우 고려X
 * > J가 1행, R행, 1열, C열에 있을 경우 바로 탈출이 가능한데 이 케이스를 구현하지 못했음
 *
 * > 이 두가지 문제점에 대해 해결하면 답이 나올 것 같음!
 *
 * 내가 처음에 시도했던 불에 대한 BFS와 지훈이에 대한 BFS를 모두 사용하는 방법이 맞았음
 * 하지만 내가 틀린 이유는? 결국 저 두 경우에 대한 처리를 하지 않아서 틀렸던 것!
 * 아이디어 자체는 맞았음. 다만, 구현과 예외처리가 서툴렀다.
 * 아이디어는 배워서 기억하고 예외를 찾는 눈을 더 기르도록 하자.
 */

public class Boj4179 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board = new char[1002][1002];
    static int[][] fDist = new int[1002][1002];
    static int[][] jDist = new int[1002][1002];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        for (int row = 0; row < R; row++) {
            Arrays.fill(fDist[row], 0, C, -1);
            Arrays.fill(jDist[row], 0, C, -1);
        }

        Queue<Pair<Integer, Integer>> q1 = new LinkedList<>();
        Queue<Pair<Integer, Integer>> q2 = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j]  == 'F') {
                    q1.add(new Pair<>(i, j));
                    fDist[i][j] = 0;
                }
                if (board[i][j]  == 'J') {
                    q2.add(new Pair<>(i, j));
                    jDist[i][j] = 0;
                }
            }
        }

        // 불 먼저 이동시키기
        while (!q1.isEmpty()) {
            Pair<Integer, Integer> cur = q1.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];

                if (nx < 0 || nx >= R || ny <= 0 || ny >= C) {
                    continue;
                }
                if (fDist[nx][ny] >= 0 || board[nx][ny] == '#') {
                    continue;
                }

                fDist[nx][ny] = fDist[cur.X][cur.Y] + 1;
                q1.add(new Pair<>(nx, ny));
            }
        }

        // 지훈이의 이동가능 경로 탐색
        while (!q2.isEmpty()) {
            Pair<Integer, Integer> cur = q2.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    System.out.println(jDist[cur.X][cur.Y] + 1);
                    return;
                }
                if (jDist[nx][ny] >= 0 || board[nx][ny] == '#') {
                    continue;
                }
                if (fDist[nx][ny] != -1 && fDist[nx][ny] <= jDist[nx][ny] + 1) {
                    continue;
                }

                jDist[nx][ny] = jDist[cur.X][cur.Y] + 1;
                q2.add(new Pair<>(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static class Pair<L, R> {

        L X;
        R Y;

        Pair(L X, R Y) {
            this.X = X;
            this.Y = Y;
        }
    }
}
