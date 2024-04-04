package baekjoon;

public class Boj4673 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] isNotSelf = new boolean[10001];

    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            findNotSelfNum(i);
        }

        for (int i = 1; i <= 10000; i++) {
            if (!isNotSelf[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void findNotSelfNum(int start) {
        int nxt = start;
        while (start != 0) {
            nxt += start % 10;
            start /= 10;
        }

        if (nxt > 10000) {
            return;
        }
        isNotSelf[nxt] = true;
        findNotSelfNum(nxt);
    }
}
