import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int n, m;
	static int max;
	static int[][] board;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			board = new int[n][n];
            max = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			// System.out.println(Arrays.deepToString(board));

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					mosquito(i, j);
			}

			System.out.println("#" + test_case + " " + max);
		}
	}

	public static void mosquito(int x, int y) {
		int sum = 0;

		int nx = x + m - 1;
		int ny = y + m - 1;

		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			for (int i = x; i <= nx; i++) {
				for (int j = y; j <= ny; j++)
					sum += board[i][j];
			}
		}
		max = Math.max(max, sum);
	}
}