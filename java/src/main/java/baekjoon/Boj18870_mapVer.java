package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj18870_mapVer {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> map = new HashMap<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add((num));
        }
        List<Integer> orderedList = list.stream().sorted()
                                        .collect(Collectors.toList());

        orderedList.forEach(num -> {
            if (!map.containsKey(num)) {
                map.put(num, map.size());
            }
        });

        list.forEach(key -> {
            sb.append(map.get(key))
              .append(' ');
        });

        System.out.println(sb);
    }
}
