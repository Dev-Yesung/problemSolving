package baekjoon;

import java.io.*;
import java.util.*;

public class Boj2660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] score = new int[52];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while (true) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            if (u == -1 && v == -1) {
                break;
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            score[i] = bfs(i);
        }

        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            minScore = Math.min(minScore, score[i]);
        }

        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (score[i] == minScore) {
                candidate.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(' ')
                .append(candidate.size()).append('\n');
        candidate.forEach(e -> sb.append(e).append(' '));

        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[52];
        Arrays.fill(distance, -1);

        distance[start] = 0;
        q.offer(start);
        while (!q.isEmpty()) {
            int cur = q.poll();

            List<Integer> list = adj.get(cur);
            for (int from : list) {
                if (distance[from] != -1) {
                    continue;
                }
                distance[from] = distance[cur] + 1;
                q.offer(from);
            }
        }

        int val = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            val = Math.max(distance[i], val);
        }

        if (val == 0) {
            return 100;
        }
        return val;
    }
}
