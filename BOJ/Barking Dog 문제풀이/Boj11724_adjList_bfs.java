package ps;

import java.io.*;
import java.util.*;

// 인접리스트를 이용한 BFS
public class Boj11724_adjList_bfs {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Integer> q = new LinkedList<>();
    static List<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean[] isVisited = new boolean[1001];
    static int n, m;
    static int connectCount;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        for (int pos = 1; pos <= n; pos++) {
            if (isVisited[pos]) {
                continue;
            }

            connectCount++;
            isVisited[pos] = true;
            q.add(pos);

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int nxt : adjList.get(cur)) {
                    if (isVisited[nxt]) {
                        continue;
                    }

                    isVisited[nxt] = true;
                    q.add(nxt);
                }
            }
        }

        System.out.println(connectCount);
    }
}
