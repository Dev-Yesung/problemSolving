package baekjoon;

// https://velog.io/@jihun333/%EB%B0%B1%EC%A4%802477-%EC%B0%B8%EC%99%B8%EB%B0%AD-%EC%9E%90%EB%B0%94

// 전체 크기는 가장 긴 가로 변 * 가장 긴 세로 변
// 가장 긴 가로 변의 양 옆의 세로의 차이가 비어있는 부분의 세로 길이가 된다.
// 가장 긴 세로 변의 양 옆의 가로의 차이가 비어있는 부분의 가로 길이가 된다.

// 생각보다 많이 어려웠음
// 도형을 회전시켜도 같은 결과가 나와야 한다는 것을 잊고 있었음
// 1,3,1,3 이 얼마나 연속으로 나오냐에 너무 집중했었는데, 이게 중요한게 아니었음
// 2,4,2,4 같은 방식으로도 회전에 의해 나올 수 있음
// 이걸 생각해본다면 내가 처음 풀었던 방법은 불가능함
// 불가능하다기보단 예외처리를 너무 많이해야만 함

import java.io.*;

class Boj2477 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[6];
        int maxWidthIdx = 0, maxWidth = 0, maxHeightIdx = 0, maxHeight = 0;
        for (int i = 0; i < 6; i++) {
            String[] param = br.readLine().split(" ");
            int dir = Integer.parseInt(param[0]);
            int val = Integer.parseInt(param[1]);

            arr[i] = val;

            // 변이 가로일 때는 dir이 1과 2일 때
            if ((dir == 1 || dir == 2) && maxWidth < val) {
                maxWidth = val;
                maxWidthIdx = i;
            }
            // 변이 세로일 때는 dir이 3과 4일 때
            if ((dir == 3 || dir == 4) && maxHeight < val) {
                maxHeight = val;
                maxHeightIdx = i;
            }
        }

        int minWidth, minHeight;
        if (maxWidthIdx == 0) {
            minWidth = Math.abs(arr[maxWidthIdx + 1] - arr[5]);
        } else if (maxWidthIdx == 5) {
            minWidth = Math.abs(arr[0] - arr[maxWidthIdx - 1]);
        } else {
            minWidth = Math.abs(arr[maxWidthIdx + 1] - arr[maxWidthIdx - 1]);
        }

        if (maxHeightIdx == 0) {
            minHeight = Math.abs(arr[maxHeightIdx + 1] - arr[5]);
        } else if (maxHeightIdx == 5) {
            minHeight = Math.abs(arr[0] - arr[maxHeightIdx - 1]);
        } else {
            minHeight = Math.abs(arr[maxHeightIdx + 1] - arr[maxHeightIdx - 1]);
        }

        System.out.println(((maxWidth * maxHeight) - (minWidth * minHeight)) * k);
    }
}
