package ps;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    static int n = 15;
    static int[] arr = new int[1_000_001];
    static int d = 3;
    static int[] p10 = new int[3];
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        p10[0] = 1;
        for (int i = 1; i < d; i++) {
            p10[i] = p10[i - 1] * 10;
        }
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < 10; j++) {
                list.set(digitNum(arr[j], i), List.of(arr[j]));
            }
            int aidx = 0;
            for (int j = 0; j < 10; j++) {
                for (Integer x : list.get(j)) {
                    arr[aidx++] = x;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }

    static int digitNum(int x, int a) {
        return (x / p10[a]) % 10;
    }


}
