import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[][] board;
	static int answer;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			answer = 0;

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++)
					board[i][j] = Integer.parseInt(st.nextToken()); // 1 = N, 2 = S
			}

			find();

			System.out.println("#" + test_case + " " + answer);
		}
	}

	public static void find() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (board[j][i] == 1) {
					for (int k = j + 1; k < 100; k++) {
						j = k;
						if (board[k][i] == 2) {
							answer++;
							break;
						}
					}
				}
			}
		}
	}
}