package baekjoon;

import java.io.*;
import java.util.*;

// 두 가지 풀이가 가능하다.
// why??
// 일단 N과 M 모두 50만이 최대이므로 시간제한 1초를 고려할 때
// O(NM)의 시간복잡를 갖는 브루트포스 방식으로는 불가능하다.
// 따라서 성능개선이 필요한데,
// 내가 아는 수준에서 선형탐색보다 빠른 건 O(logN)의 시간복잡도를 갖는 탐색이고 이분탐색이다.
// 이분탐색에 있어 두 가지 선택지가 존재하는데 하나는 말그대로 이분탐색을 하는거고
// 다른 하나는 이분탐색트리를 만든다음에 결과 값을 찾는거다.
// 사실 풀이에 있어 더 쉬운 방법은 이분탐색트리를 만드는거지만 학습을 위해 둘 다 풀어보도록 한다.

public class Boj10816 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        br.readLine();
        String[] input = br.readLine().split(" ");
        int[] cards = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        br.readLine();
        input = br.readLine().split(" ");
        int[] nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        Arrays.stream(cards).forEach(card -> {
//            if (map.containsKey(card)) {
//                int val = map.get(card);
//                map.put(card, val + 1);
//            } else {
//                map.put(card, 1);
//            }
            map.put(card, map.getOrDefault(card, 0) + 1);
        });

        Arrays.stream(nums).forEach(num -> {
            if (map.containsKey(num)) {
                sb.append(map.get(num))
                  .append(' ');
            } else {
                sb.append(0)
                  .append(' ');
            }
        });

        System.out.println(sb);
    }
}
