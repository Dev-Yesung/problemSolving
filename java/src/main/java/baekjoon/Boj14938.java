package baekjoon;

import java.io.*;
import java.util.*;

public class Boj14938 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int r = Integer.parseInt(params[2]);

        int[] items = new int[n + 1];
        params = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(params[i - 1]);
        }

        List<List<Vertex>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            params = br.readLine().split(" ");
            int s = Integer.parseInt(params[0]);
            int e = Integer.parseInt(params[1]);
            int w = Integer.parseInt(params[2]);

            adj.get(s).add(new Vertex(e, w));
            adj.get(e).add(new Vertex(s, w));
        }

        int[] distance = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance, Integer.MAX_VALUE);
            Arrays.fill(isVisited, false);

            PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
            pq.offer(new Vertex(i, 0));
            distance[i] = 0;

            while (!pq.isEmpty()) {
                Vertex cur = pq.poll();
                int pos = cur.end;

                if (!isVisited[pos]) {
                    isVisited[pos] = true;

                    for (Vertex v : adj.get(pos)) {
                        if (!isVisited[v.end] && distance[v.end] > distance[pos] + v.weight) {
                            distance[v.end] = distance[pos] + v.weight;
                            pq.add(new Vertex(v.end, distance[v.end]));
                        }
                    }
                }
            }

            int total = 0;
            for (int j = 1; j <= n; j++) {
                if (distance[j] <= m) {
                    total += items[j];
                }
            }

            answer = Math.max(answer, total);
        }

        System.out.println(answer);
    }

    static class Vertex {
        int end;
        int weight;

        public Vertex(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
