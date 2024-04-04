package baekjoon;

import java.io.*;
import java.util.*;

public class Boj7785 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, String> map = new HashMap<>();
    static List<String> names = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        String name, status;
        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            name = log[0];
            status = log[1];

            map.put(name, status);
            names.add(name);
        }

        names.stream()
             .distinct()
             .filter(person -> map.get(person).equals("enter"))
             .sorted(Collections.reverseOrder())
             .forEach(person -> sb.append(person).append('\n'));

        System.out.println(sb);
    }
}
