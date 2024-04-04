package baekjoon;

import java.io.*;
import java.util.*;

/**
 * BFS를 사용해야만 하는 이유 가야할 경로들 중에 가장 먼저 목적지에 도달했을 때가 최소 경로이기 때문에<br>
 * 이 경우 한 방향으로만 탐색을 하는 DFS말고 가야할 경로를 두루두루 탐색하는 BFS로 구현해야 한다.<br>
 * "BFS로 구현할 경우 최악의 탐색 경우를 면할 수 있다"는 알고리즘 아이디어가 있다.<br>
 * --> 예전에 알고리즘 수업에서 residual network를 공부할 때 배웠던 아이디어이다. 이것을 기억하고 있자.<br>
 * <p>
 * DFS가 안되는 이유?<br>
 * DFS는 한쪽 방향으로 계속 탐색해서 목적지에 도달하게 된다.<br>
 * 하지만 DFS로 구현하게 될 경우 목적지에 도달한 모든 값들을 저장해놔야하고 그 중에서 최솟값을 찾아야함<br>
 * 또한 DFS로 구현하게 될 경우 이전에 이동했던 경로도 초기화해야할 뿐만 아니라 DFS의 종료조건을 찾기가 너무 어렵다. 따라서 BFS로 구현하는게 최선이다.<br>
 */
public class Boj2178 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Pair<Integer, Integer>> q = new LinkedList<>();
    static int[][] board = new int[102][102];
    static boolean[][] vis = new boolean[102][102];
    static int[][] move = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static boolean isFind;

    public static void main(String[] args) throws IOException {
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j + 1] = Integer.parseInt(line[j]);
            }
        }

        vis[1][1] = true;
        q.add(new Pair<>(1, 1));

        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];

                if (nx < 1 || nx > N || ny < 1 || ny > M) {
                    continue;
                }
                if (board[nx][ny] != 1 || vis[nx][ny]) {
                    continue;
                }

                vis[nx][ny] = true;
                move[nx][ny] = dir;
                if (nx == N && ny == M) {
                    isFind = true;
                    break;
                }
                q.add(new Pair<>(nx, ny));
            }

            if (isFind) {
                break;
            }
        }

        int min = 1;
        int searchX = N, searchY = M;
        while (!(searchX == 1 && searchY == 1)) {
            int before = move[searchX][searchY];
            min++;
            if (before == 0) {
                searchX -= dx[0];
            } else if (before == 1) {
                searchY -= dy[1];
            } else if (before == 2) {
                searchX -= dx[2];
            } else if (before == 3) {
                searchY -= dy[3];
            }
        }

        System.out.println(min);
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
