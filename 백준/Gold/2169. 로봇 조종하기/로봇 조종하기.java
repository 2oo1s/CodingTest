import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] board, dp, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dp = new int[n][m];
        temp = new int[2][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.deepToString(board));

        dp[0][0] = board[0][0];

        for (int i = 1; i < m; i++)
            dp[0][i] = dp[0][i - 1] + board[0][i];
        
        for (int i = 1; i < n; i++) {
            // 왼쪽 & 아래쪽으로 이동
            temp[0][0] = dp[i - 1][0] + board[i][0];
            for (int j = 1; j < m; j++)
                temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + board[i][j];

            // 오른쪽 & 아래쪽으로 이동
            temp[1][m - 1] = dp[i - 1][m - 1] + board[i][m - 1];
            for (int j = m - 2; j >= 0; j--)
                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + board[i][j];

            for (int j = 0; j < m; j++)
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}