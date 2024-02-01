package ps;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj18870 {

    // 중복 숫자를 모두 유일하게 만든 다음
    // upper bound와 lower bound 이용해서 길이 구하고
    // 그 upper bound - (upper bound - lower bound)  = 좌표 압축길이 =  lower bound

    // 정리 : 입력 -> 정렬 -> 중복원소제거 -> lower bound 구하기

    // 해시 맵이나 트리 맵으로도 구할 수 있을 듯?
    // counting으로도 구할 수 있을 듯?

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    static List<Integer> pos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        pos.addAll(list);

        // list.sort(Integer::compareTo)
        Collections.sort(list);
        // 스트림을 이용한 중복제거 : https://developer-talk.tistory.com/728
        list = list.stream().distinct().collect(Collectors.toList());
        pos.forEach(num -> {
            sb.append(getLowerBound(list, num))
              .append(' ');
        });

        System.out.println(sb);
    }

    static int getLowerBound(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size();

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (target <= list.get(mid)) {
                hi = mid;
                continue;
            }
            lo = mid + 1;
        }
        return lo;
    }
}
