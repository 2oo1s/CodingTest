import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[][] board;
	static int max;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			int[][] board = new int[100][100];

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}

			int max = 0, diagSum1 = 0, diagSum2 = 0;

			for (int i = 0; i < 100; i++) {
				int rowSum = 0, colSum = 0;
				for (int j = 0; j < 100; j++) {
					rowSum += board[i][j];
					colSum += board[j][i];
				}
				max = Math.max(max, Math.max(rowSum, colSum));

				diagSum1 += board[i][i];
				diagSum2 += board[i][99 - i];
			}
			max = Math.max(max, Math.max(diagSum1, diagSum2));

			System.out.println("#" + test_case + " " + max);
		}
	}
}