package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 인접리스트, 스택, 재귀와 같은 순서로 작동하는 DFS
public class Boj11724_stack_adjList_dfs {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> s = new Stack<>();
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
            s.push(pos);
            while (!s.isEmpty()) {
                int cur = s.pop();

                if (isVisited[cur]) {
                    continue;
                }
                isVisited[cur] = true;

                for (int next : adjList.get(cur)) {
                    if (isVisited[next]) {
                        continue;
                    }

                    s.push(next);
                }
            }
        }

        System.out.println(connectCount);
    }
}
