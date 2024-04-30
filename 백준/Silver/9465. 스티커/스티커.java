import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n];

			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < n; k++)
					arr[j][k] = Integer.parseInt(st.nextToken());
			}
			// System.out.print(Arrays.deepToString(arr));

			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];

			for (int j = 1; j < n; j++) {
				dp[0][j] = Math.max(dp[0][j - 1], dp[1][j - 1] + arr[0][j]);
				dp[1][j] = Math.max(dp[1][j - 1], dp[0][j - 1] + arr[1][j]);
			}
			System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
		}
	}
}
