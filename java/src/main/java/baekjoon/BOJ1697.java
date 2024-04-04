package baekjoon;

import java.io.*;
import java.util.*;

// 문제 오해
// -> 같은 위치에 있으면 그냥 바로 찾은 걸로쳐서 0출력하면 끝남

// 문제에서 오해하면 안될 점 2
// : 수빈이의 이동 위치가 반드시 0~100_000 사이에 있어야 한다는 보장이 없다!
// 즉, 10만을 넘어가더라도 동생을 빨리 찾을 수 있다면 상관이 없는 것이다.

// 문제를 다시 한 번 보도록 하자. "수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고"라고 쓰여있다.
// 다시 말하면 수빈이의 시작위치가 이 사이에 있다는 것이지 이동하고 나서는 이 위치를 벗어날 수 있다는 말이다.

// 하지만 이 문제에서는 운 좋게 위치가 10만을 넘기게 되거나 위치가 음수로 갈 경우 비효율 적인 탐색이 된다는게 보장이 되기 때문에 고려할 필요가 없는 것이다.
// 만일 수빈이의 순간이동이 곱하기 2뿐만 아니라 나누기 2도 된다면,
// 혹은 음수 인덱스로 갔을 때 효율적으로 이동할 수 있는 어떤 조건이 있다면
// 이 부분은 충분히 조심해야 한다. 문제를 오해하지 말자!!
public class Boj1697 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] map = new int[100_001];
    static Queue<Integer> q = new LinkedList<>();
    static int[] move = {1, -1, 2};

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Arrays.fill(map, 0, 100_001, -1);
        map[N] = 0;
        q.add(N);

        // 조건을 이렇게만 설정해도 되는 이유는
        // 현재 시작 위치는 하나이고 BFS의 특성상 시작위치가 하나일 때 같은 위치에서
        // 최단 경로를 찾게 되면 가장 먼저 도착한 값이 최단경로가 된다.
        while (map[K] == -1) {
            int cur = q.poll();

            // 아래와 같은 방식으로 for 문을 구현해서 돌릴 수 있다는 아이디어를 기억하자.
            int[] dir = {cur + move[0], cur + move[1], cur * move[2]};
            for (int pos : dir) {
                if (pos < 0 || pos > 100_000) {
                    continue;
                }
                if (map[pos] > -1) {
                    continue;
                }
                map[pos] = map[cur] + 1;
                q.add(pos);
            }
        }

        System.out.println(map[K]);
    }
}
