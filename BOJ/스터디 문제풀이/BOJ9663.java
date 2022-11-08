import java.io.*;
import java.util.*;

class BOJ9663 {
    static int n;
    static int a[][];
    static int cnt = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        a = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++) {
            a[1][i] = 1;
            dfs(1, i);
            a[1][i] = 0;
        }
        
        System.out.println(cnt);
    }
    
    public static void dfs(int r, int c) {
        if(r == n) {
            cnt++;
            return;
        }
        
        for(int i=1; i<=n; i++) {
            if(setQueen(r+1, i)) {
                a[r+1][i] = 1;
                dfs(r+1, i);
                a[r+1][i] = 0;
            }
        }
    }
    
    public static boolean setQueen(int r, int c) {
        for(int i=1; i<r; i++) {
            for(int j=1; j<=n; j++) {
                if(a[i][j] == 1 && j == c)
                    return false;
                if(a[i][j] == 1 && Math.abs(i - r) == Math.abs(j - c))
                    return false;
            }
        }
        return true;
    }	
}
