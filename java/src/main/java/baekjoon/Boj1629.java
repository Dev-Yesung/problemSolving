package baekjoon;

import java.io.*;
import java.util.*;

// 정수론에 관한 이론은 https://sskl660.tistory.com/75 참고

// 또한 재귀로 풀릴만한 문제가 있다면 눈으로 풀어도 나올만한 것이 아니라면
// 귀찮더라도 반드시 점화식을 똑바로 세우고 문제를 풀자
// 제대로된 점화식을 세우면 그 점화식을 그대로 재귀로 옮기면 끝이기 때문에
// 점화식을 잘 세우는 것이 더 중요하다.

// 여기서 알아둬야할 것은 k에 대한 식을 계산했다면 2k와 2k+1이 모두 O(1)에 탐색 된다는 것을 아는 것이다.
// 이 점화식의 시간복잡도는 대략 O(logN)이다. N은 대략 21억 즉, int의 범위인 2^32이므로 O(32)정도로 계산할 수 있다.
public class Boj1629 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long C = Long.parseLong(input[2]);

        System.out.println(solution(A, B, C));
    }

    static long solution(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long result = solution(A, B / 2, C);
        result = result * result % C;
        if (B % 2 == 0) {
            return result;
        }
        return result * A % C;
    }
}
