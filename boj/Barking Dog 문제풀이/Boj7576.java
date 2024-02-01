package ps;

import java.io.*;
import java.util.*;

/**
 *  내가 사용했던 방식으로 큐를 돌릴필요 없다.
 *  만일 익은 토마토의 위치를 distance를 표시하는 방식으로 하게 되면
 *  굳이 for문을 사용해서 하루에 처리해야할 토마토를 넣는 방식이 아니라
 *  원래 bfs했던 방식대로 하나씩 토마토를 꺼내서 처리하면 된다.
 *  -> Boj7576_ver2를 참고
 */
public class Boj7576 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Pair<Integer, Integer>> startQ = new LinkedList<>();
    static int[][] container = new int[1002][1002];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static boolean isNotAble;
    static boolean isAlreadyComplete;

    public static void main(String[] args) throws IOException {
        String[] size = br.readLine().split(" ");
        M = Integer.parseInt(size[0]);
        N = Integer.parseInt(size[1]);

        int zeroCount = 0;
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            for (int j = 1; j <= M; j++) {
                int status = Integer.parseInt(st.nextToken());
                if (status != 0) {
                    container[i][j] = status;
                    if (status == 1) {
                        startQ.add(new Pair<>(i, j));
                    }
                } else {
                    zeroCount++;
                }
            }
        }

        if (zeroCount == 0) {
            isAlreadyComplete = true;
        }

        int totalDay = 0;
        while (!isAlreadyComplete && !startQ.isEmpty()) {
            int dayWorkSize = startQ.size();
            for (int i = 0; i < dayWorkSize; i++) {
                Pair<Integer, Integer> start = startQ.poll();
                Queue<Pair<Integer, Integer>> q = new LinkedList<>();
                q.add(start);

                while (!q.isEmpty()) {
                    Pair<Integer, Integer> cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.X + dx[dir];
                        int ny = cur.Y + dy[dir];

                        if (nx < 1 || nx > N || ny < 1 || ny > M) {
                            continue;
                        }
                        if (container[nx][ny] != 0) {
                            continue;
                        }

                        container[nx][ny] = 1;
                        startQ.add(new Pair<>(nx, ny));
                    }
                }
            }
            totalDay++;
        }
        totalDay--;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (container[i][j] == 0) {
                    isNotAble = true;
                    break;
                }
            }
        }

        if (isNotAble) {
            System.out.println(-1);
        } else if (isAlreadyComplete) {
            System.out.println(0);
        } else {
            System.out.println(totalDay);
        }
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
