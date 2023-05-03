package ps;

import java.util.*;

public class Boj1193_ver2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int x = sc.nextInt();

        int cross_count = 1, prev_count_sum = 0;
        while (true) {
            if (x <= prev_count_sum + cross_count) {
                int numer, denumer;

                if (cross_count % 2 == 1) {
                    numer = cross_count - (x - prev_count_sum - 1);
                    denumer = x - prev_count_sum;
                } else {
                    numer = x - prev_count_sum;
                    denumer = cross_count - (x - prev_count_sum - 1);
                }

                System.out.println(numer + "/" + denumer);
                break;
            } else {
                prev_count_sum += cross_count;
                cross_count++;
            }
        }
    }
}
