import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** BOJ1182 */
public class BOJ1182 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, S, count = 0;
  static String[] str;
  static int[] arr = new int[20];

  public static void main(String[] args) throws IOException {
    str = br.readLine().split(" ");
    N = Integer.parseInt(str[0]);
    S = Integer.parseInt(str[1]);

    str = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(str[i]);
    }

    backTracking(0, 0);
    if (S == 0) {
      System.out.print(count - 1);
    } else {
      System.out.print(count);
    }
  }

  public static void backTracking(int v, int sum) {
    if (v == N) {
      if (sum == S) count++;
      return;
    }

    backTracking(v + 1, sum + arr[v]);
    backTracking(v + 1, sum);
  }
}
