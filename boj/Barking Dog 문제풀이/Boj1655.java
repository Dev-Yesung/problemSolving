package ps;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/*
    처음 생각했던 방법
    >>>>
    priority queue 두 개를 만든다. 하나는 오름차순 정렬, 하나는 내림차순 정렬
    큐의 사이즈가 홀수인지 짝수인지 파악
    if 홀수라면 어느쪽에서든지 가운데 숫자가 하나이므로 그 숫자를 답으로 한다.
    if 짝수라면 같은 횟수로 poll 을 진행한 후 둘 중 작은 수를 가운데 수로 정함

    But 이 방법으로 진행할 경우 메모리 초과가 발생한다.
    why? 들어온 순서대로 원소를 저장하고 있는 리스트를
    우선순위 큐에 addAll 메서드로 복원시키게 되면
    10만이나 되는 수행에서 메모리를 그만큼 많이 잡아먹게 된다.

    ----------------------------------------

    메모리초과가 나지 않는 방법을 찾아야 한다.
    https://github.com/Dev-Yesung/basic-algo-lecture/blob/master/0x17/solutions/1655.cpp
    >>>>
    minheap 인 우선순위 큐에서 가운데의 원소 중에 작은 원소는 왼쪽으로 큰 원소는 오른쪽으로 위치한다.
    따라서 전체 들어온 수를 반으로 나눈 후 minheap 과 maxheap 에 반씩 저장한다.
    두 힙의 크기를 균등하게 유지하도록 만든다.

    maxheap 은 전체 들어온 수 중, 왼쪽에 해당한다.
    그래서 맨 앞에 왼쪽 원소중에 큰 원소가 오게 된다.

    minheap 은 전체 들어온 수 중, 오른쪽에 해당한다.
    그래서 맨 앞에 오른쪽 원소중에 작은 원소가 오게 된다.
 */
public class Boj1655 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> left = new PriorityQueue<>((e1, e2) -> e2 - e1);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (left.size() <= right.size()) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            if (!right.isEmpty() && right.peek() < left.peek()) {
                right.offer(left.poll());
                left.offer(right.poll());
            }

            sb.append(left.peek())
              .append('\n');
        }

        System.out.println(sb);
    }
}
