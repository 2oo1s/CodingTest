import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static String[][] board;
	static HashSet<String> set;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			board = new String[4][4];
			set = new HashSet<>();

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++)
					board[i][j] = st.nextToken();
			}
			// System.out.println(Arrays.deepToString(board));
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)
					dfs(i, j, 0, "" + board[i][j]);
			}

			System.out.println("#" + test_case + " " + set.size());
		}
	}

	public static void dfs(int i, int j, int len, String str) {
		if (len == 6) {
			set.add(str);
			return;
		}

		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4)
				dfs(nx, ny, len + 1, str + board[nx][ny]);
		}
	}
}