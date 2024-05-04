import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			int max = 0;

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++)
					board[i][j] = str.charAt(j) - '0';
			}
			// System.out.println(Arrays.deepToString(board));
			int mid = n / 2;

			for (int i : board[mid])
				max += i;

			int jump = 0;

			for (int i = mid - 1; i >= 0; i--) {
				jump += 1;
				for (int j = jump; j < n - jump; j++)
					max += board[i][j];
			}

			jump = 0;

			for (int i = mid + 1; i < n; i++) {
				jump += 1;
				for (int j = jump; j < n - jump; j++)
					max += board[i][j];
			}

			System.out.println("#" + test_case + " " + max);
		}
	}
}