package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1926_DFS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Location<Integer, Integer>> list = new LinkedList<>();
    static Stack<Location<Integer, Integer>> stack = new Stack<>();
    static int[][] board = new int[502][502];
    static boolean[][] vis = new boolean[502][502];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            for (int j = 1; j <= M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    board[i][j] = 1;
                    list.add(new Location<>(i, j));
                }
            }
        }

        List<Integer> picSizeList = new LinkedList<>();
        int totalPicNum = 0;
        while (!list.isEmpty()) {
            Location<Integer, Integer> start = list.poll();
            if (vis[start.X][start.Y]) {
                continue;
            }
            vis[start.X][start.Y] = true;
            stack.push(start);
            totalPicNum++;

            int sizeCounter = 1;
            while (!stack.isEmpty()) {
                Location<Integer, Integer> cur = stack.pop();
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
                    stack.add(new Location<>(nx, ny));
                    sizeCounter++;
                }
            }

            picSizeList.add(sizeCounter);
        }

        int max = Integer.MIN_VALUE;
        for (int picSize : picSizeList) {
            if(max < picSize) {
                max = picSize;
            }
        }

        if (totalPicNum == 0) {
            System.out.println(totalPicNum + "\n" + 0);
        } else {
            System.out.println(totalPicNum + "\n" + max);
        }
    }

    static class Location<L, R> {
        L X;
        R Y;

        Location(L X, R Y) {
            this.X = X;
            this.Y = Y;
        }
    }

}
