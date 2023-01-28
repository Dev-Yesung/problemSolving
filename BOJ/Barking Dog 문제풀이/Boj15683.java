package ps;

import java.io.*;
import java.util.*;

class Cctv implements Comparable<Cctv> {

    int type;
    int xPos;
    int yPos;

    Cctv(int type, int xPos, int yPos) {
        this.type = type;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public int compareTo(Cctv cctv) {
        if (this.type > cctv.type) {
            return -1;
        } else if (this.type < cctv.type) {
            return 1;
        }
        return 0;
    }
}

public class Boj15683 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Cctv> q = new PriorityQueue<>();
    static int[][] board;
    static int N, M;

    public static void main(String[] args) throws IOException {
        String size = br.readLine();
        StringTokenizer st = new StringTokenizer(size, " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line, " ");

            for (int j = 1; j <= M; j++) {
                int obj = Integer.parseInt(st.nextToken());
                if (obj >= 1 && obj <= 5) {
                    board[i][j] = obj;
                    q.add(new Cctv(obj, i, j));
                }
                if (obj == 6) {
                    board[i][j] = 6;
                }
            }
        }

        while (!q.isEmpty()) {
            Cctv curCctv = q.poll();
            int type = curCctv.type;
            int xPos = curCctv.xPos;
            int yPos = curCctv.yPos;
            String dir = findMaxDir(type, xPos, yPos);
            coverBoard(type, xPos, yPos, dir);
        }

        int nonCover = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] == 0) {
                    nonCover++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.printf("%3d ", board[i][j]);
            }
            System.out.println();
        }

        System.out.println(nonCover);
    }

    static void coverBoard(int type, int xPos, int yPos, String dir) {
        if (type == 1) {
            if (dir.equals("d1")) {
                coverUp(xPos, yPos);
            } else if (dir.equals("d2")) {
                coverDown(xPos, yPos);
            } else if (dir.equals("d3")) {
                coverLeft(xPos, yPos);
            } else if (dir.equals("d4")) {
                coverRight(xPos, yPos);
            }
        } else if (type == 2) {
            if (dir.equals("d1")) {
                coverUp(xPos, yPos);
                coverDown(xPos, yPos);
            } else if (dir.equals("d2")) {
                coverLeft(xPos, yPos);
                coverRight(xPos, yPos);
            }
        } else if (type == 3) {
            if (dir.equals("d1")) {
                coverRight(xPos, yPos);
                coverUp(xPos, yPos);
            } else if (dir.equals("d2")) {
                coverUp(xPos, yPos);
                coverLeft(xPos, yPos);
            } else if (dir.equals("d3")) {
                coverLeft(xPos, yPos);
                coverDown(xPos, yPos);
            } else if (dir.equals("d4")) {
                coverDown(xPos, yPos);
                coverRight(xPos, yPos);
            }
        } else if (type == 4) {
            if (dir.equals("d1")) {
                coverRight(xPos, yPos);
                coverUp(xPos, yPos);
                coverLeft(xPos, yPos);
            } else if (dir.equals("d2")) {
                coverUp(xPos, yPos);
                coverLeft(xPos, yPos);
                coverDown(xPos, yPos);
            } else if (dir.equals("d3")) {
                coverLeft(xPos, yPos);
                coverDown(xPos, yPos);
                coverRight(xPos, yPos);
            } else if (dir.equals("d4")) {
                coverDown(xPos, yPos);
                coverRight(xPos, yPos);
                coverUp(xPos, yPos);
            }
        } else if (type == 5) {
            coverUp(xPos, yPos);
            coverLeft(xPos, yPos);
            coverDown(xPos, yPos);
            coverRight(xPos, yPos);
        }
    }

    static String findMaxDir(int type, int xPos, int yPos) {
        int d1 = 0, d2 = 0, d3 = 0, d4 = 0;
        if (type == 1) {
            d1 = countUp(xPos, yPos);
            d2 = countDown(xPos, yPos);
            d3 = countLeft(xPos, yPos);
            d4 = countRight(xPos, yPos);
        } else if (type == 2) {
            d1 = countUp(xPos, yPos) + countDown(xPos, yPos);
            d2 = countLeft(xPos, yPos) + countRight(xPos, yPos);
        } else if (type == 3) {
            d1 = countRight(xPos, yPos) + countUp(xPos, yPos);
            d2 = countUp(xPos, yPos) + countLeft(xPos, yPos);
            d3 = countLeft(xPos, yPos) + countDown(xPos, yPos);
            d4 = countDown(xPos, yPos) + countRight(xPos, yPos);
        } else if (type == 4) {
            d1 = countRight(xPos, yPos) + countUp(xPos, yPos) + countLeft(xPos, yPos);
            d2 = countUp(xPos, yPos) + countLeft(xPos, yPos) + countDown(xPos, yPos);
            d3 = countLeft(xPos, yPos) + countDown(xPos, yPos) + countRight(xPos, yPos);
            d4 = countDown(xPos, yPos) + countRight(xPos, yPos) + countUp(xPos, yPos);
        }
        return findMax(d1, d2, d3, d4);
    }

    static String findMax(int d1, int d2, int d3, int d4) {
        List<Integer> list = List.of(d1, d2, d3, d4);
        int max = Integer.MIN_VALUE;
        for (int val : list) {
            if (max < val) {
                max = val;
            }
        }

        String maxDir = "";
        if (d1 == max) {
            maxDir = "d1";
        } else if (d2 == max) {
            maxDir = "d2";
        } else if (d3 == max) {
            maxDir = "d3";
        } else if (d4 == max) {
            maxDir = "d4";
        }

        return maxDir;
    }

    static int countUp(int xPos, int yPos) {
        int count = 0;
        for (int curX = xPos; curX >= 1; curX--) {
            if (board[curX][yPos] == 6) {
                break;
            }
            if (board[curX][yPos] == -1) {
                continue;
            }
            count++;
        }
        return count;
    }

    static void coverUp(int xPos, int yPos) {
        for (int curX = xPos; curX >= 1; curX--) {
            if (board[curX][yPos] == 6) {
                break;
            }
            if (board[curX][yPos] == -1) {
                continue;
            }
            board[curX][yPos] = -1;
        }
    }

    static int countDown(int xPos, int yPos) {
        int count = 0;
        for (int curX = xPos; curX <= N; curX++) {
            if (board[curX][yPos] == 6) {
                break;
            }
            if (board[curX][yPos] == -1) {
                continue;
            }
            count++;
        }
        return count;
    }

    static void coverDown(int xPos, int yPos) {
        for (int curX = xPos; curX <= N; curX++) {
            if (board[curX][yPos] == 6) {
                break;
            }
            if (board[curX][yPos] == -1) {
                continue;
            }
            board[curX][yPos] = -1;
        }
    }

    static int countLeft(int xPos, int yPos) {
        int count = 0;
        for (int curY = yPos; curY >= 1; curY--) {
            if (board[xPos][curY] == 6) {
                break;
            }
            if (board[xPos][curY] == -1) {
                continue;
            }
            count++;
        }
        return count;
    }

    static void coverLeft(int xPos, int yPos) {
        for (int curY = yPos; curY >= 1; curY--) {
            if (board[xPos][curY] == 6) {
                break;
            }
            if (board[xPos][curY] == -1) {
                continue;
            }
            board[xPos][curY] = -1;
        }
    }

    static int countRight(int xPos, int yPos) {
        int count = 0;
        for (int curY = yPos; curY <= M; curY++) {
            if (board[xPos][curY] == 6) {
                break;
            }
            if (board[xPos][curY] == -1) {
                continue;
            }
            count++;
        }
        return count;
    }

    static void coverRight(int xPos, int yPos) {
        for (int curY = yPos; curY <= M; curY++) {
            if (board[xPos][curY] == 6) {
                break;
            }
            if (board[xPos][curY] == -1) {
                continue;
            }
            board[xPos][curY] = -1;
        }
    }
}
