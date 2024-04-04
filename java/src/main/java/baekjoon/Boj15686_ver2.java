package baekjoon;

import java.io.*;
import java.util.*;

// 처음에 이 방법을 생각했는데, 잘 되지 않았음
// 어째튼 처음 방법과 이 방법은 큰 차이는 없음.
// 다만 이 코드가 더 깔끔함
// 나는 조합이 되는 것의 개수를 모두 구한 후 최종적으로
// https://steady-coding.tistory.com/23
public class Boj15686_ver2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Pos> home = new ArrayList<>();
    static List<Pos> chicken = new ArrayList<>();
    static boolean[] vis;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int m = Integer.parseInt(param[1]);

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (line[j].equals("1")) {
                    home.add(new Pos(i, j));
                }
                if (line[j].equals("2")) {
                    chicken.add(new Pos(i, j));
                }
            }
        }

        vis = new boolean[chicken.size()];
        dfs(0, 0, m);
        System.out.println(ans);
    }

    static void dfs(int cur, int cnt, int m) {
        if (cnt == m) {
            int res = 0;
            for (int i = 0; i < home.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                Pos h = home.get(i);
                // 조합의 개수를 vis가 true인 집합을 가지고 만들었음
                // 굳이 새로 조합의 개수를 만들 필요는 없다!
                // 여기서의 단점이라면 돌필요 없는 배열을 모두 돌아야 한다.
                for (int j = 0; j < chicken.size(); j++) {
                    Pos c = chicken.get(j);
                    if (vis[j]) {
                        int dist = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
                        tmp = Math.min(tmp, dist);
                    }
                }
                res += tmp;
            }
            ans = Math.min(ans, res);
            return;
        }

        for (int i = cur; i < chicken.size(); i++) {
            vis[i] = true;
            dfs(i + 1, cnt + 1, m);
            vis[i] = false;
        }
    }

    static class Pos {
        int r;
        int c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
