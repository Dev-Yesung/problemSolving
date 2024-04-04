package baekjoon;

import java.io.*;
import java.util.*;

public class Boj11723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> s = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] param = br.readLine().split(" ");
            String cmd = param[0];
            int num = 0;
            if (!cmd.equals("all") && !cmd.equals("empty")) {
                num = Integer.parseInt(param[1]);
            }

            if (cmd.equals("add")) {
                s.add(num);
            }
            if (cmd.equals("remove")) {
                s.remove(num);
            }
            if (cmd.equals("check")) {
                if (s.contains(num)) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append('\n');
            }
            if (cmd.equals("toggle")) {
                if (s.contains(num)) {
                    s.remove(num);
                } else {
                    s.add(num);
                }
            }
            if (cmd.equals("all")) {
                for (int n = 1; n <= 20; n++) {
                    s.add(n);
                }
            }
            if (cmd.equals("empty")) {
                s.clear();
            }
        }

        System.out.print(sb);
    }
}
