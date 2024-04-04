package baekjoon;

import java.io.*;
import java.util.*;

public class Boj1620 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, String> idxMap = new HashMap<>();
    static Map<String, String> nameMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 1; i <= n; i++) {
            String pokeName = br.readLine();
            idxMap.put(String.valueOf(i), pokeName);
            nameMap.put(pokeName, String.valueOf(i));
        }

        for (int i = 0; i < m; i++) {
            String cmd = br.readLine();
            if (idxMap.containsKey(cmd)) {
                sb.append(idxMap.get(cmd))
                  .append('\n');
            }
            if (nameMap.containsKey(cmd)) {
                sb.append(nameMap.get(cmd))
                  .append('\n');
            }
        }

        System.out.println(sb);
    }
}
