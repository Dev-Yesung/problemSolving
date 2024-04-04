package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, e;
    static List<List<Node>> adj;
    static int[] dist;
    static boolean[] vis;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        n = Integer.parseInt(param[0]);
        e = Integer.parseInt(param[1]);

        adj = new ArrayList<>();
        dist = new int[n + 1];
        vis = new boolean[n + 1];

        Arrays.fill(dist, INF);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int weight = Integer.parseInt(line[2]);

            adj.get(start).add(new Node(end, weight));
            adj.get(end).add(new Node(start, weight));
        }

        String[] target = br.readLine().split(" ");
        int v1 = Integer.parseInt(target[0]);
        int v2 = Integer.parseInt(target[1]);

        int result1 = 0;
        result1 += dij(1, v1);
        result1 += dij(v1, v2);
        result1 += dij(v2, n);

        int result2 = 0;
        result2 += dij(1, v2);
        result2 += dij(v2, v1);
        result2 += dij(v1, n);

        int answer = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);
        System.out.println(answer);
    }

    static int dij(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(vis, false);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        boolean[] check = new boolean[n + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : adj.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[end];
    }

    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
