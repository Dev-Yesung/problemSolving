package baekjoon;

import java.io.*;
import java.util.*;

class Boj15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Pos> home = new ArrayList<>();
    static List<Pos> store = new ArrayList<>();
    static List<Pos> list = new ArrayList<>();
    static int n, m;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        n = Integer.parseInt(param[0]);
        m = Integer.parseInt(param[1]);

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (line[j].equals("1")) {
                    home.add(new Pos(i, j));
                }
                if (line[j].equals("2")) {
                    store.add(new Pos(i, j));
                }
            }
        }

        boolean[] isVisited = new boolean[store.size()];
        for (int r = 1; r <= store.size(); r++) {
            comb(isVisited, 0, r);
        }

        System.out.println(answer);
    }

    static void comb(boolean[] isVisited, int depth, int r) {
        if (list.size() == m) {
            int t = 0;
            for (Pos h : home) {
                int min = Integer.MAX_VALUE;
                for (Pos s : list) {
                    int dist = Math.abs(h.r - s.r) + Math.abs(h.c - s.c);
                    min = Math.min(min, dist);
                }
                t += min;
            }
            answer = Math.min(answer, t);
            return;
        }
        if (r == 0) {
            return;
        }
        if (depth == store.size()) {
            return;
        }

        list.add(store.get(depth));
        isVisited[depth] = true;
        comb(isVisited, depth + 1, r - 1);
        list.remove(list.size() - 1);
        isVisited[depth] = false;

        comb(isVisited, depth + 1, r);
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
