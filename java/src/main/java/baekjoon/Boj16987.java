package baekjoon;

import java.io.*;
import java.util.*;

public class Boj16987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<int[]> list = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;
    static boolean[] vis;
    static int count;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int h = Integer.parseInt(line[0]);
            int w = Integer.parseInt(line[1]);
            list.add(new int[] {h, w});
        }

        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            count = 0;
            recursion(i, i + 1, n);
        }
        System.out.println(answer);
    }

    static void recursion(int start, int nxt, int len) {
        if (nxt < len && vis[nxt]) {
            return;
        }
        if (nxt == len) {
            answer = Math.max(answer, count);
            return;
        }

        for (int j = nxt; j < len; j++) {
            int[] egg1 = list.get(start);
            int[] egg2 = list.get(j);

            if (egg1[0] - egg2[1] <= 0 || egg2[0] - egg1[1] > 0) {
                break;
            }
            if (egg2[0] - egg1[1] <= 0) {
                vis[j] = true;
                count++;
                recursion(start, j, len);
                count--;
                vis[j] = false;
            }
        }
    }
}
