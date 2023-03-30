package ps;

import java.io.*;
import java.util.*;

// https://velog.io/@lifeisbeautiful/%EB%B0%B1%EC%A4%80-11724%EB%B2%88-%EC%97%B0%EA%B2%B0-%EC%9A%94%EC%86%8C%EC%9D%98-%EA%B0%9C%EC%88%98-Java
// 인접리스트 생성에 대한 코드 참조

public class Boj11724_recur_adjList_dfs {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        for (int next : adjList.get(cur)) {
            if (isVisited[next]) {
                continue;
            }

            dfs(next);
        }
    }
}
