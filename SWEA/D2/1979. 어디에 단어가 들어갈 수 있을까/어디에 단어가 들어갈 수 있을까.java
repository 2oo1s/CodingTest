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
			st = new StringTokenizer(br.readLine(), " ");

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int answer = 0;
			int cnt = 0;
			int[][] board = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				cnt = 0;
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 1)
						cnt++;
					else
						cnt = 0;

					if (cnt == k) {
						if (j == n - 1) {
							answer++;
							cnt = 0;
						} else {
							if (board[i][j + 1] == 0) {
								answer++;
								cnt = 0;
							}
						}
					}

				}
			}

			for (int i = 0; i < n; i++) {
				cnt = 0;
				for (int j = 0; j < n; j++) {
					if (board[j][i] == 1)
						cnt++;
					else
						cnt = 0;

					if (cnt == k) {
						if (j == n - 1) {
							answer++;
							cnt = 0;
						} else {
							if (board[j + 1][i] == 0) {
								answer++;
								cnt = 0;
							}
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}