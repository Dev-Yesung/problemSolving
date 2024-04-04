package baekjoon;

import java.io.*;
import java.util.*;

// https://bbangson.tistory.com/73
// Arrays.binarySearch 라는 Arrays 클래스의 static 메서드가 존재한다.
// 사용방법을 익히자
// https://codingdog.tistory.com/entry/java-arrays-binarysearch-%ED%95%A8%EC%88%98%EB%A5%BC-%EC%95%8C%EC%95%84%EB%B4%85%EC%8B%9C%EB%8B%A4

public class Boj1920 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // stream 으로 배열만드는 것을 처리했기 때문에 사실상 필요 없는 부분
        Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] a = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        // stream 으로 배열만드는 것을 처리했기 때문에 사실상 필요 없는 부분
        Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        int[] nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        Map<Integer,Integer> tree = new TreeMap<>();

        // 순서대로 비교할 경우 O(MN)의 시간복잡도가 걸린다.
        // Binary search를 이용해 O(M*logN)의 시간으로 개선하자

        // !!! 정렬에 필요한 시간복잡도는 O(N*logN)이다.
        // 따라서 총 시간 복잡도는 O(N*logN + M*logN)이다.
        // 따라서 M의 크기가 크냐 N의 크기가 크냐에 따라
        // 시간복잡도가 O(N*logN) 혹은 O(M*logN)이 되겠지만
        // N, M이 모두 10만 이하이므로 최대 시간복잡도는 대략 O(20만 * log20만)일 것이다.

        // 시간제한은 1초이내이다. 시간복잡도는 10 ~ 20억을 초과하지 않는다.
        // 만일 O(NM)의 시간복잡도를 갖게되면 무조건 20억 초과이다.
        Arrays.sort(a);
        for (int i = 0; i < nums.length; i++) {
            boolean isExist = binSearch(a, nums[i]);

            if (isExist) {
                sb.append(1)
                  .append('\n');
                continue;
            }
            sb.append(0)
              .append('\n');
        }

        System.out.print(sb);
    }

    static boolean binSearch(int[] a, int num) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num < a[mid]) {
                end = mid - 1;
                continue;
            }
            if (num == a[mid]) {
                return true;
            }
            if (num > a[mid]) {
                start = mid + 1;
            }
        }
        return false;
    }
}
