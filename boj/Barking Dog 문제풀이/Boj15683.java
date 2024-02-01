package ps;

import java.io.*;
import java.util.*;

/*
    난이도가 꽤 있지만, 배울 부분이 많은 문제이기도 하다.
    일단 문제가 최소값을 요구하고 있다.
    최소값을 찾으려면 최적화가 들어가는 문제(그리디, 다이나믹 프로그래밍)이거나
    완전탐색이나 백트레킹을 통해 답을 찾아야 한다.
    이 경우, 완전탐색으로 하는게 맞는것 같다.

    내가 처음 시도해봤던 방식은 그리디하게 찾는 방식이었다.
    어떤 방식의 그리디였냐면 CCTV의 종류와 위치에 따라 커버할 수 있는 범위가 많은 것을 선택하는 방법이었다.
    하지만 어디선가 삐꾸가 나서 테스트케이스를 만족못해서 실패했었다.
    결국 어디서 예외가 난건지 찾지 못했고, 답을 보고 완전탐색으로 풀었다.

    https://blog.encrypted.gg/948
    일단 완전탐색이 가능한 이유는 입력 값 자체의 크기가 매우 작기 때문이다.
    기껏해봐야 8 x 8이고 시간제한도 1초로 넉넉한 편이다.
    그리고 코드를 작성한 후 시간제한을 검증해보니, 아주 넉넉한 편이었다.

    완탐으로 문제풀 때 핵심은 가질 수 있는 조합을 모두 찾는 것이었다.
    CCTV는 4종류가 있고 각 종류마다 가질 수 있는 경우의 수는 4, 2, 4, 4, 1 가지다.
    CCTV의 개수가 여러 대라면 위의 경우의 수에 거듭제곱이 들어가는 조합의 수가 나온다.
    하지만 내가 참조한 풀이는 더 괜찮은 방식으로 조합을 찾아낸다.

    위의 CCTV의 경우의 수를 모두 4로 맞추고 4진수를 이용해 모든 조합을 찾아낸다.
    어떻게 2가지만 있는 경우를 4가지로 늘릴 수 있는가?
    방향을 한 번에 잡는 것이 아니라 한쪽 방향을 잡고 그에 따라 나머지 방향을 잡으면 된다.

    CCTV가 가질 수 있는 방향을 좌, 우, 위, 아래의 네 가지 방향으로 통일했기 때문에 가능한 것이다.
    > 이 테크닉은 요긴하게 쓰일 수 있을 거 같으니 잘 기억해두자!

    물론 이렇게 계산하게 되면 경우의 수가 기존보다 더 많이 나오기 때문에
    더 많은 계산을 수행하게 된다. 하지만 인풋 값이 작고, 시간도 넉넉하기 때문에 상관 없다.
    오히려 예외처리를 줄일 수 있는 방식이기 때문에 문제풀이에는 안성맞춤이다!

    만일 시간 제한이 1초가 아니라 0.5초였다면?
    일단, 완전탐색을 생각 안했을 것이다. 어떻게든 그리디하게 찾아내려고 노력하지 않았을까?
    하지만 0.5초임에도 완전탐색이 가능하다.
 */

public class Boj15683 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board1, board2;
    static int n, m;

    public static void main(String[] args) throws IOException {
        String[] param = br.readLine().split(" ");
        n = Integer.parseInt(param[0]);
        m = Integer.parseInt(param[1]);

        board1 = new int[n + 2][m + 2];
        board2 = new int[n + 2][m + 2];

        int min = 0;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] val = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board1[i][j] = Integer.parseInt(val[j]);
                if (board1[i][j] != 0 && board1[i][j] != 6) {
                    list.add(new Pair<>(i, j));
                }
                if (board1[i][j] == 0) {
                    min++;
                }
            }
        }

        for (int tmp = 0; tmp < (1 << (2 * list.size())); tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board2[i][j] = board1[i][j];
                }
            }

            int combi = tmp;
            for (int i = 0; i < list.size(); i++) {
                int dir = combi % 4;
                combi /= 4;

                int x = list.get(i).x;
                int y = list.get(i).y;
                if (board1[x][y] == 1) {
                    mark(x, y, dir);
                } else if (board1[x][y] == 2) {
                    mark(x, y, dir);
                    mark(x, y, dir + 2);
                } else if (board1[x][y] == 3) {
                    mark(x, y, dir);
                    mark(x, y, dir + 1);
                } else if (board1[x][y] == 4) {
                    mark(x, y, dir);
                    mark(x, y, dir + 1);
                    mark(x, y, dir + 2);
                } else {
                    mark(x, y, dir);
                    mark(x, y, dir + 1);
                    mark(x, y, dir + 2);
                    mark(x, y, dir + 3);
                }
            }

            int val = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board2[i][j] == 0) {
                        val++;
                    }
                }
            }
            min = Integer.min(min, val);
        }

        System.out.println(min);
    }

    static void mark(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (isOutOfBound(x, y) || board2[x][y] == 6) {
                return;
            }
            if (board2[x][y] != 0) {
                continue;
            }
            board2[x][y] = 7;
        }
    }

    static boolean isOutOfBound(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    static class Pair<L, R> {

        L x;
        R y;

        Pair(L x, R y) {
            this.x = x;
            this.y = y;
        }
    }
}
