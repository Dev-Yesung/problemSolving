package baekjoon;

import java.io.*;
import java.util.*;

// 1. 인접행렬과 DFS 를 이용한 풀이
public class Boj11724 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> s = new Stack<>();
    static int[][] adj = new int[1001][1001];
    static boolean[] isVisited = new boolean[1001];
    static int n, m;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            adj[x][y] = 1;
            adj[y][x] = 1;
        }

        int connectCount = 0;
        for (int loc = 1; loc <= n; loc++) {
            if (isVisited[loc]) {
                continue;
            }
            connectCount++;
            isVisited[loc] = true;
            s.push(loc);

            while (!s.isEmpty()) {
                int cur = s.pop();

                for (int col = 1; col <= n; col++) {
                    if (adj[cur][col] != 1) {
                        continue;
                    }
                    if (isVisited[col]) {
                        continue;
                    }

                    isVisited[col] = true;
                    s.push(col);
                }
            }
        }

        System.out.println(connectCount);
    }
}
