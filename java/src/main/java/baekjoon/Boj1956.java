package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1956 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] params = br.readLine().split(" ");
        int v = Integer.parseInt(params[0]);
        int e = Integer.parseInt(params[1]);

        int[][] adj = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j) {
                    adj[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            params = br.readLine().split(" ");
            int start = Integer.parseInt(params[0]);
            int end = Integer.parseInt(params[1]);
            int weight = Integer.parseInt(params[2]);

            adj[start][end] = weight;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (i != j && adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j && adj[i][j] != Integer.MAX_VALUE && adj[j][i] != Integer.MAX_VALUE) {
                    min = Math.min(adj[i][j] + adj[j][i] , min);
                }
            }
        }

        if (min != Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}
