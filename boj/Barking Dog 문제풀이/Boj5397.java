package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Boj5397 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    static LinkedList<Character> logger = new LinkedList<>();
    static List<String> result = new ArrayList<>();
    static ListIterator<Character> cursor;
    static int ts;
    static String L;

    public static void main(String[] args) throws IOException {
        ts = Integer.parseInt(br.readLine());

        for (int i = 0; i < ts; i++) {
            sb = new StringBuilder();
            L = br.readLine();

            cursor = logger.listIterator();
            for (Character ch : L.toCharArray()) {
                switch (ch) {
                    case '<':
                        if (cursor.hasPrevious()) {
                            cursor.previous();
                        }
                        break;
                    case '>':
                        if (cursor.hasNext()) {
                            cursor.next();
                        }
                        break;
                    case '-':
                        if (!cursor.hasPrevious()) {
                            continue;
                        }

                        cursor.previous();
                        cursor.remove();
                        break;
                    default:
                        cursor.add(ch);
                }
            }

            for (Character ch : logger) {
                sb.append(ch);
            }
            result.add(sb.toString());

            logger.clear();
        }

        result.forEach(System.out::println);
    }
}
