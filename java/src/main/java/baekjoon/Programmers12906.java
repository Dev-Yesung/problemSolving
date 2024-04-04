package baekjoon;

import java.util.*;

public class Programmers12906 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }

    public static int[] solution(int[] arr) {
        Deque<Integer> s = new LinkedList<>();
        s.add(Integer.MIN_VALUE);
        Arrays.stream(arr).filter(elem -> s.peekLast() != elem).forEach(s::add);
        s.pollFirst();
        // https://stackoverflow.com/questions/718554/how-to-convert-an-arraylist-containing-integers-to-primitive-int-array
        return s.stream().mapToInt(Integer::intValue).toArray();
    }
}
