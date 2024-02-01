package ps;

import java.io.*;
import java.util.*;

public class Boj1158 {

    static List<Integer> numbers = new LinkedList<>();
    static List<Integer> josephus = new ArrayList<>();
    static Iterator<Integer> iter;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;
    static int counter;
    static int elem;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        st = new StringTokenizer(input, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; ++i) {
            numbers.add(i);
        }

        iter = numbers.iterator();
        while (!numbers.isEmpty()) {
            if (!iter.hasNext()) {
                iter = numbers.iterator();
            }
            elem = iter.next();
            counter++;

            if (counter == K) {
                iter.remove();
                josephus.add(elem);
                counter = 0;
            }
        }

        int length = josephus.size();
        sb.append('<');
        for (int i = 0; i < length; ++i) {
            sb.append(josephus.get(i));
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append('>');

        System.out.println(sb.toString());
    }
}
