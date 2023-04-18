package ps;

import java.io.*;
import java.util.*;


/*
    전형적인 그리디 문제
    왜 그리디로 풀어야만 했는지를 정확하게 파악하는게 중요하다.
    그리디 문제라 검증한 과정
    1. 시간의 길이가 긴 것이 먼저 올 수록 뒤에 대기하는 인원들의 시간이 점점 늘어남
    2. 이걸 알고 있는 이유는 알고리즘 수업시간에 검증했었음
    3. 따라서 대기시간이 작은 원소들부터 무조건 먼저 선택하는게 총 대기시간을 줄임
    -> 그리디!
 */
public class Boj11399 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] params = br.readLine().split(" ");
        int[] times = Arrays.stream(params).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(times);

//        int reduce = 0;
//        List<Integer> list = new ArrayList<>();
//        for (int time : times) {
//            reduce += time;
//            list.add(reduce);
//        }
//        int answer = list.stream().reduce(Integer::sum).get();
        int answer = 0;
        for (int i = 0; i < times.length; i++) {
            answer += times[i] * (times.length - i);
        }
        System.out.println(answer);
    }
}
