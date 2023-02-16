package ps;

import java.io.*;
import java.util.*;

/*
 * 자바에는 multi-set tree 가 없다.
 * 다시 말하면 중복을 허용하는 값을 넣을 수 있는 BST 컬렉션이 없다.
 * 이것을 해결하기 위해 TreeMap 에서 key 값이 같은 것이 들어오면,
 * 그것의 개수를 Value 로 저장하는 방식을 이용해 구현하면 된다.
 * 기억하도록 하자.
 */

public class Boj7662 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, k;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tree = new TreeMap<>();

            for (int cnt = 0; cnt < k; cnt++) {
                String[] input = br.readLine().split(" ");

                int number = Integer.parseInt(input[1]);
                if (input[0].equals("I")) {
                    tree.put(number, tree.getOrDefault(number, 0) + 1);
                }
                if (input[0].equals("D")) {
                    if (tree.isEmpty()) {
                        continue;
                    }

                    int key = (number == 1 ? tree.lastKey() : tree.firstKey());
                    if (tree.get(key) > 1) {
                        tree.put(key, tree.get(key) - 1);
                        continue;
                    }
                    tree.remove(key);
                }
            }

            if (tree.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(tree.lastKey())
                  .append(' ')
                  .append(tree.firstKey());
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
