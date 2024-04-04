package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2. 인접행렬을 이용한 DFS recursion 을 이용한 풀이
public class Boj11724_recursion {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] adj = new int[1001][1001];
    static boolean[] isVisited = new boolean[1001];
    static int n, m;
    static int connectCount = 0;

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

        for (int cur = 1; cur <= n; cur++) {
            if (isVisited[cur]) {
                continue;
            }

            dfs(cur);
            connectCount++;
        }

        System.out.println(connectCount);
    }

    static void dfs(int cur) {
        isVisited[cur] = true;

        for (int nxt = 1; nxt <= n; nxt++) {
            if (adj[cur][nxt] != 1 || isVisited[nxt]) {
                continue;
            }
            dfs(nxt);
        }
    }
}
