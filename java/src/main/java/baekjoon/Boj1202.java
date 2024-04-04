package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj1202 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]);
        int k = Integer.parseInt(param[1]);

        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int m = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            tree.put(m, v);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int c = Integer.parseInt(br.readLine());
            list.add(c);
        }
        list.sort((a, b) -> a - b);

        int total = 0;
        for (int weight : list) {
            int maxW = tree.floorKey(weight);
            Set<Map.Entry<Integer, Integer>> set = tree.entrySet();
            List<Integer> l = set.stream()
                    .filter((e) -> e.getKey() <= maxW)
                    .map((e) -> e.getKey())
                    .sorted()
                    .collect(Collectors.toList());

            int maxKey = l.get(0);
            int maxVal = tree.get(l.get(0));
            for (int key : l) {
                int curKey = key;
                int curVal = tree.get(key);

                if (curVal > maxVal) {
                    tree.put(maxKey, maxVal);
                    maxKey = curKey;
                    maxVal = curVal;
                    tree.remove(curKey, curVal);
                } else if (curVal == maxVal) {
                    if (curKey > maxKey) {
                        tree.put(maxKey, maxVal);
                        maxKey = curKey;
                        tree.remove(maxKey);
                    }
                }
            }
            total += maxVal;
        }

        System.out.println(total);
    }
    // 이거 굳이 가방 구분할 필요 없지않나...?
    // 그냥 무게가 최대인거 찾아서 값 찾아서 하면 되지 않나
}
