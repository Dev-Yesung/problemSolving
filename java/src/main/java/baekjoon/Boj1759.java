package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Boj1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static StringBuilder tmp;
    static String[] alpha;
    static boolean[] vis;
    static int min1 = 0, min2 = 0;
    static int totalLen = 0;

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int l = Integer.parseInt(param[0]);
        int c = Integer.parseInt(param[1]);

        alpha = new String[c];
        vis = new boolean[c];
        String[] elems = br.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            alpha[i] = elems[i];
        }

        for (int i = 0; i < c; i++) {
            tmp = new StringBuilder();
            totalLen = 0;
            recursion(l, i, c);
        }
        System.out.print(answer);
    }

    static void recursion(int len, int idx, int c) {
        if (vis[idx]) {
            return;
        }
        if (len == 0) {
            if (min1 >= 1 && min2 >= 2) {
                // 여기서 tmp 소팅
                String[] t = tmp.toString().split("");
                String sorted = Arrays.stream(t).sorted().collect(Collectors.joining());
                answer.append(sorted).append('\n');
            }
            return;
        }

        if (alpha[idx].equals("a") || alpha[idx].equals("e") || alpha[idx].equals("i") || alpha[idx].equals("o") || alpha[idx].equals("u")) {
            min1++;
        } else {
            min2++;
        }

        vis[idx] = true;
        tmp.append(alpha[idx]);
        totalLen++;
        for (int i = idx + 1; i <= c; i++) {
            recursion(len - 1, i, c);
        }
        totalLen--;
        tmp.deleteCharAt(totalLen);
        vis[idx] = false;

        if (alpha[idx].equals("a") || alpha[idx].equals("e") || alpha[idx].equals("i") || alpha[idx].equals("o") || alpha[idx].equals("u")) {
            min1--;
        } else {
            min2--;
        }
    }
}
