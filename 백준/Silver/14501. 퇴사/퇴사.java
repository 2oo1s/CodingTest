import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] table;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        table = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int idx, int cost) {
        if (idx >= n) {
            answer = Math.max(cost, answer);
            return;
        }

        if (idx + table[idx][0] <= n)
            dfs(idx + table[idx][0], cost + table[idx][1]);
        else
            dfs(idx + table[idx][0], cost);
        
        dfs(idx + 1, cost);
    }
}