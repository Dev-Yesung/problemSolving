package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1647 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int m = Integer.parseInt(param[1]);

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            param = br.readLine().split(" ");
            int start = Integer.parseInt(param[0]);
            int end = Integer.parseInt(param[1]);
            int val = Integer.parseInt(param[2]);

            list.add(new Edge(start, end, val));
        }
        list.sort((a, b) -> a.val - b.val);

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int ans = 0;
        int maxVal = 0;
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);

            if (find(e.start) != find(e.end)) {
                ans += e.val;
                union(e.start, e.end);

                maxVal = e.val;
            }
        }

        System.out.println(ans - maxVal);
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    static class Edge {
        int start;
        int end;
        int val;

        public Edge(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
}
