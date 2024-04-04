package baekjoon;

import java.io.*;
import java.util.*;

/*  재귀문제를 풀 때는 반드시 재귀식을 잘 세우고 코딩을 하자!!
 *  ## 재귀는 절차지향적으로 생각하는 방식에서 벗어나야만 한다!
 *  ## 수학적 귀납법(induction)으로 생각하자!
 *  1. 함수를 정의한다.
 *  2. base condition을 찾는다.
 *  3. 재귀 식을 만든다.
 *  재귀는 식을 짜는 것도 중요하지만 식을 코딩하는 순서도 상당히 중요하다.
 *  순서가 논리적으로 잘 맞는지 확인해서 짜자
 */
public class Boj11729 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = sc.nextInt();
        int totalMove = hanoiTower(1, 2, 3, N);
        System.out.println(totalMove);
        System.out.println(sb);
    }

    static int hanoiTower(int start, int middle, int end, int N) {
        if (N == 1) {
            sb.append(start).append(' ').append(end).append('\n');
            return 1;
        }
        int h1 = hanoiTower(start, end, middle, N - 1);
        sb.append(start).append(' ').append(end).append('\n');
        int h2 = hanoiTower(middle, start, end, N - 1);
        return h1 + h2 + 1;
    }
}
