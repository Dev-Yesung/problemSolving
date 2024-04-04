package baekjoon;

import java.io.*;
import java.util.*;

public class Boj2056 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];
        int[] time = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] params = br.readLine().split(" ");
            time[i] = Integer.parseInt(params[0]);

            int count = Integer.parseInt(params[1]);
            for (int j = 0; j < count; j++) {
                int tmp = Integer.parseInt(params[2 + j]);
                adjList.get(tmp).add(i);

                indegree[i]++;
            }
        }

        int ans = solution(n, adjList, indegree, time);
        System.out.println(ans);
    }

    private static int solution(int n, List<List<Integer>> adjList, int[] indegree, int[] time) {
        Queue<Integer> q = new LinkedList<>();

        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = time[i];

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int nxt : adjList.get(curr)) {
                indegree[nxt]--;

                result[nxt] = Math.max(result[nxt], result[curr] + time[nxt]);
                if (indegree[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }

        return Arrays.stream(result)
                .max()
                .orElse(0);
    }

}
