package baekjoon;

import java.io.*;
import java.util.*;

public class Boj21939 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        TreeSet<Problem> tree = new TreeSet<>((e1, e2) -> {
            if (e1.level == e2.level) {
                return e2.index - e1.index;
            }
            return e2.level - e1.level;
        });
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] problem = br.readLine().split(" ");
            int p = Integer.parseInt(problem[0]);
            int l = Integer.parseInt(problem[1]);

            tree.add(new Problem(p, l));
            map.put(p, l);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");

            if ("add".equals(line[0])) {
                int p = Integer.parseInt(line[1]);
                int l = Integer.parseInt(line[2]);

                tree.add(new Problem(p, l));
                map.put(p, l);
            }
            if ("recommend".equals(line[0])) {
                if ("1".equals(line[1])) {
                    sb.append(tree.first().index);
                }
                if ("-1".equals(line[1])) {
                    sb.append(tree.last().index);
                }
                sb.append('\n');
            }
            if ("solved".equals(line[0])) {
                int index = Integer.parseInt(line[1]);

                tree.remove(new Problem(index, map.get(index)));
                map.remove(index);
            }
        }

        System.out.print(sb);
    }

    static class Problem {
        int index;
        int level;

        Problem(int index, int level) {
            this.index = index;
            this.level = level;
        }
    }

}
