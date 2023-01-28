//package ps;
//
//// 이 틀을 그냥 외우자!
//
//import java.io.*;
//import java.util.*;
//
// Pair 클래스를 만들어서 BFS 에 이용
//class Pair<L, R> {
//
//    L X;
//    R Y;
//
//    Pair(L x, R y) {
//        this.X = x;
//        this.Y = y;
//    }
//}
//
//public class BarkingDogBFSBasicFrameEx {
//    static Queue<Pair<Integer, Integer>> Q = new LinkedList<>();
//    static int[][] board =
//            {
//                    {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
//                    {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                    {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
//                    {1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
//                    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//            };
//    static boolean[][] vis = new boolean[502][502];
//    static int[] dx = {1, 0, -1, 0};
//    static int[] dy = {0, 1, 0, -1};
//    static int n = 7, m = 10;
//
//    public static void main(String[] args) {
//        vis[0][0] = true;
//        Q.add(new Pair<>(0, 0));
//        while (!Q.isEmpty()) {
//            Pair<Integer, Integer> cur = Q.poll();
//            System.out.print("(" + cur.X + ", " + cur.Y + ") -> ");
//            for (int dir = 0; dir < 4; dir++) {
//                // 방문 순서는 아래쪽, 오른쪽, 위쪽, 왼쪽
//                int nx = cur.X + dx[dir];
//                int ny = cur.Y + dy[dir];
//
//                // 아래의 if 문의 순서를 바꾸면 안된다! why?
//                // => 배열의 유효한 범위가 아닐 수 있기 때문에 런타임 에러가 발생할 수 있음!
//                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
//                    continue;
//                }
//                if (vis[nx][ny] || board[nx][ny] != 1) {
//                    continue;
//                }
//
//                vis[nx][ny] = true;
//                Q.add(new Pair<>(nx, ny));
//            }
//        }
//    }
//
//}
