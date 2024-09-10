import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        int[] dp = new int[11];

        dp[1] = 1;  // 1 = 1
        dp[2] = 2;  // 2 = 1 + 1 = 2
        dp[3] = 4;  // 3 = 1 + 1 + 1 = 1 + 2 = 2 + 1 = 3

        /*
        dp[4] = 1 + 3 -> 3을 만드는 방법은 dp[3]만큼 가능
              = 2 + 2 -> 2를   "    "   dp[2]만큼 가능
              = 3 + 1 -> 1을   "    "   dp[1]만큼 가능
         */
        for (int i = 4; i < 11; i++)
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n]);
        }
    }
}