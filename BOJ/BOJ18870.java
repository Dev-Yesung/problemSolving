import java.io.*;
import java.util.*;

class IntegerComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer num1, Integer num2) {
        if(num1 > num2) return 1;
        else if(num1 < num2) return -1;
        return 0;
    }
}

public class BOJ18870 {
    public static ArrayList<Integer> origin = new ArrayList<>();
    public static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<Integer> sortedOrder = new ArrayList<>();
    public static HashMap<Integer, Integer>map = new HashMap<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(values[i]);
            origin.add(num);
            list.add(num);
        }

        list.sort(new IntegerComparator());

        sortedOrder.add(0,0);
        if(list.size() > 1) {
            for (int i = 1; i < count; i++) {
                if (list.get(i - 1) < list.get(i)) {
                    sortedOrder.add(i, sortedOrder.get(i - 1) + 1);
                } else {
                    sortedOrder.add(i, sortedOrder.get(i - 1));
                }
            }
        }

        for(int i = 0; i < count; i++) {
            map.put(list.get(i), sortedOrder.get(i));
        }

        for(int i = 0; i < count; i++) {
            sb.append(map.get(origin.get(i)) + " ");
        }
        System.out.println(sb.toString());
    }
}
