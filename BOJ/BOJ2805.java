import java.io.*;
import java.util.*;

class treeComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer tree1, Integer tree2) {
        if(tree1 > tree2) return 1;
        else if(tree1 < tree2) return -1;
        return 0;
    }
}


public class Main {
    public static ArrayList<Integer> trees =  new ArrayList<>();
    public static int calculated = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int treeNum = Integer.parseInt(line[0]);
        int required = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        for(int i = 0; i < treeNum; i++) {
            int num = Integer.parseInt(line[i]);
            trees.add(num);
        }
        trees.sort(new treeComparator());

        long result = iterSolution(required);
        System.out.println(result);
    }

    public static long iterSolution(int required) {
        int totalLength = 0;
        int nextMedianIdx = 0;
        long median = 0;
        long first = trees.get(0), last = trees.get(trees.size()-1);

        while(true) {
            totalLength = 0;
            median = (first + last)/2;

            for(int i = ; i <= end; i++) {
                if(trees.get(i) - median <= 0) continue;
                else {
                    nextMedianIdx = i;
                    totalLength += (long)(trees.get(i) - median);
                }
            }

            if(totalLength == required) break;
            else if(totalLength > required) first = nextMedianIdx;
            else end = nextMedianIdx;
        }

        return median;
    }
}
