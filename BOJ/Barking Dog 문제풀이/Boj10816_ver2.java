package ps;

import java.io.*;
import java.util.*;

// 오름차순 정렬된 수열에 원소가 추가될 경우를 생각해봤을 때
// 오름차순의 성질이 유지되도록 새로운 원소를 삽입하는 방법은
// 1. 삽입하고자 하는 원소보다 최초로 큰 원소가 나오는 위치
// 2. 삽입하고자 하는 원소가 최초로 등장하는 위치
// 두 인덱스의 차이가 수열에 존재하는 찾고자하는 원소의 개수이다.
// 만일 찾고자하는 원소가 수열에 없다면
// 최초로 등장하는 찾고자하는 수보다 큰 원소의 위치의 인덱스끼리의 차가 발생해
// 값이 0이 된다.

// 여러가지 풀이가 가능
// https://st-lab.tistory.com/267
public class Boj10816_ver2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br.readLine();
        String[] input = br.readLine().split(" ");
        int[] cards = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        br.readLine();
        input = br.readLine().split(" ");
        int[] nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(cards);
        for (int num : nums) {
            int lowerBound = getLowerBound(cards, num);
            int upperBound = getUpperBound(cards, num);

            sb.append(upperBound - lowerBound)
              .append(' ');
        }

        System.out.println(sb);
    }

    static int getLowerBound(int[] cards, int target) {
        int lo = 0;
        int hi = cards.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (target <= cards[mid]) {
                hi = mid;
                continue;
            }
            lo = mid + 1;
        }
        return lo;
    }

    static int getUpperBound(int[] cards, int target) {
        int lo = 0;
        int hi = cards.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (target < cards[mid]) {
                hi = mid;
                continue;
            }
            lo = mid + 1;
        }
        return lo;
    }
}
