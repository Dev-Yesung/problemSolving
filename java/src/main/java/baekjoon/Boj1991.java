package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1991 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, String> lc = new HashMap<>();
    static Map<String, String> rc = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");

            if (!line[1].equals(".")) {
                lc.put(line[0], line[1]);
            }
            if (!line[2].equals(".")) {
                rc.put(line[0], line[2]);
            }
        }

        preOrder("A");
        sb.append('\n');
        inOrder("A");
        sb.append('\n');
        postOrder("A");

        System.out.println(sb);
    }

    static void preOrder(String cur) {
        sb.append(cur);
        if (lc.containsKey(cur)) {
            preOrder(lc.get(cur));
        }
        if (rc.containsKey(cur)) {
            preOrder(rc.get(cur));
        }
    }

    static void inOrder(String cur) {
        if (lc.containsKey(cur)) {
            inOrder(lc.get(cur));
        }
        sb.append(cur);
        if (rc.containsKey(cur)) {
            inOrder(rc.get(cur));
        }
    }

    static void postOrder(String cur) {
        if (lc.containsKey(cur)) {
            postOrder(lc.get(cur));
        }
        if (rc.containsKey(cur)) {
            postOrder(rc.get(cur));
        }
        sb.append(cur);
    }
}
