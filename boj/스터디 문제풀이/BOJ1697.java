import java.io.*;
import java.util.*;

/** BOJ1697 */
public class BOJ1697 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static Queue<Integer> q = new LinkedList<>();
  static String[] str;
  static int n, k;
  static int[] count = new int[100001];

  public static void main(String[] args) throws IOException {
    str = br.readLine().split(" ");
    n = Integer.parseInt(str[0]);
    k = Integer.parseInt(str[1]);

    if (n >= k) {
      bw.write((n - k) + "\n");
      bw.flush();
      bw.close();
    } else {
      bfs();
    }
  }

  static void bfs() throws IOException {
    q.add(n);

    while (!q.isEmpty()) {
      int now = q.poll();

      for (int i = 0; i < 3; i++) {
        int nxt;

        if (i == 0) {
          nxt = now + 1;
        } else if (i == 1) {
          nxt = now - 1;
        } else {
          nxt = now * 2;
        }

        if (nxt == k) {
          bw.write((count[now] + 1) + "\n");
          bw.flush();
          bw.close();
          return;
        }

        if (nxt >= 0 && nxt < count.length && count[nxt] == 0) {
          q.add(nxt);
          count[nxt] = count[now] + 1;
        }
      }
    }
  }
}
