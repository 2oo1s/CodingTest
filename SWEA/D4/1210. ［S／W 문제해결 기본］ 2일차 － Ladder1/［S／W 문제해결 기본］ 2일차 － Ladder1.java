import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[][] board;
	static int n = 100;
	static int x, y;
	static int answer;

	static int[] dx = { 0, 0, -1 };
	static int[] dy = { -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int t = Integer.parseInt(br.readLine());

			board = new int[n][n];
			answer = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			move(x, y);

			System.out.println("#" + t + " " + answer);
		}
	}

	public static void move(int i, int j) {
		while (true) {
			if (i == 0) {
				answer = j;
				break;
			}

			for (int k = 0; k < 3; k++) {
				int nx = i + dx[k];
				int ny = j + dy[k];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
					board[i][j] = -1;
					i = nx;
					j = ny;
				}
			}
		}
	}
}