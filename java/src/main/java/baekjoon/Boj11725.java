package baekjoon;

import java.io.*;
import java.util.*;

public class Boj11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] p = new int[100001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        // 리스트를 이중으로 만들려면 초기화하는 과정을 거쳐야 한다.
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] param = br.readLine().split(" ");
            int n1 = Integer.parseInt(param[0]);
            int n2 = Integer.parseInt(param[1]);

            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            sb.append(p[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int cur) {
        for (int nxt : adj.get(cur)) {
            if (p[cur] == nxt) {
                continue;
            }
            p[nxt] = cur;
            dfs(nxt);
        }
    }
}
