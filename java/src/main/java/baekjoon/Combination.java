package baekjoon;

public class Combination {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; //조합을 만들 배열
        boolean[] visited = new boolean[arr.length];

        //1. 백트래킹을 이용해 구현
        System.out.println("1.백트래킹");
        comb1(arr, visited, 0, 3);

        //2. 재귀를 이용해 구현
        System.out.println("\n2.재귀");
        comb2(arr, visited, 0, 3);
    }

    //1. 백트래킹을 이용해 구현
    static void comb1(int[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            print(arr, visited);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            comb1(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }

    //2. 재귀를 이용해 구현
    static void comb2(int[] arr, boolean[] visited, int depth, int r) {
        if (r == 0) {
            print(arr, visited);
            return;
        }
        if (depth == arr.length) {
            return;
        }

        visited[depth] = true;
        comb2(arr, visited, depth + 1, r - 1);
        visited[depth] = false;

        comb2(arr, visited, depth + 1, r);
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
