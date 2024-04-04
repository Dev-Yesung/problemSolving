package baekjoon;

import java.io.*;
import java.util.*;

public class Boj11779 {
    static List<Edge>[] list;
    static int n, m, start, end;
    static int[] dist;
    static int[] route;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");

            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            int p = Integer.parseInt(line[2]);
            list[s].add(new Edge(e, p));
        }

        String[] line = br.readLine().split(" ");
        start = Integer.parseInt(line[0]);
        end = Integer.parseInt(line[1]);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Edge(start, 0));

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        route = new int[n + 1];
        route[start] = 0;

        isVisited = new boolean[n + 1];
        while (!pq.isEmpty()) {
            Edge curE = pq.poll();

            if (!isVisited[curE.end]) {
                isVisited[curE.end] = true;
            } else {
                continue;
            }

            for (int i = 0; i < list[curE.end].size(); i++) {
                Edge nxtE = list[curE.end].get(i);
                if (dist[nxtE.end] > dist[curE.end] + nxtE.weight) {
                    dist[nxtE.end] = dist[curE.end] + nxtE.weight;
                    pq.offer(new Edge(nxtE.end, dist[nxtE.end]));
                    route[nxtE.end] = curE.end;
                }
            }
        }

        System.out.println(dist[end]);

        List<Integer> routes = new ArrayList<>();
        int cur = end;
        while (cur != 0) {
            routes.add(cur);
            cur = route[cur];
        }
        System.out.println(routes.size());

        for (int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
