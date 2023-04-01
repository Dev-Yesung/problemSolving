package ps;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrEx2 {

    //메모이제이션을 활용해서 풀게되면 O(N^2)이 아닌 O(N)에 풀 수 있다.
    private static int[] arr = new int[101];
    private static int N;
    private static String numbers;
    private static Scanner sc = new Scanner(System.in);
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) {
        N = sc.nextInt();
        numbers = sc.nextLine();

        stringTokenizer = new StringTokenizer(numbers, " ");

        while (stringTokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            arr[num]++;
        }

        int result = 0;
        for (int i = 0; i < 101; i++) {
            if (arr[i] != 0 && arr[100 - i] != 0) {
                result = 1;
                break;
            }
        }


        System.out.println(result);
    }
}
