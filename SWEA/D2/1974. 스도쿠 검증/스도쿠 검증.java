import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[][] board;
	/*
	 * 0 1 2
	 * 3 4 5
	 * 6 7 8
	 */
	static boolean sectionIsFilled;
	static boolean rowIsFilled;
	static boolean colIsFilled;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			board = new int[9][9];
			sectionIsFilled = true;
			rowIsFilled = true;
			colIsFilled = true;

			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}

			checkSection();
			checkRow();
			checkCol();

			if (sectionIsFilled && rowIsFilled && colIsFilled)
				System.out.println("#" + test_case + " " + 1);
			else
				System.out.println("#" + test_case + " " + 0);
		}
	}

	public static void checkSection() {
		for (int i = 0; i < 9; i += 3) {
			HashSet<Integer> set = new HashSet<>(); // size = 9이면 조건 만족
			for (int j = 0; j < 9; j += 3) {
				set.add(board[i][j]);
				set.add(board[i + 1][j]);
				set.add(board[i + 2][j]);
				set.add(board[i][j + 1]);
				set.add(board[i][j + 2]);
				set.add(board[i + 1][j + 1]);
				set.add(board[i + 2][j + 2]);
				set.add(board[i + 1][j + 2]);
				set.add(board[i + 2][j + 1]);

				if (set.size() != 9)
					sectionIsFilled = false;
			}
		}
	}

	public static void checkRow() {
		for (int i = 0; i < 9; i++) {
			HashSet<Integer> set = new HashSet<>();
			for (int j = 0; j < 9; j++)
				set.add(board[i][j]);

			if (set.size() != 9)
				rowIsFilled = false;
		}
	}

	public static void checkCol() {
		for (int i = 0; i < 9; i++) {
			HashSet<Integer> set = new HashSet<>();
			for (int j = 0; j < 9; j++)
				set.add(board[j][i]);

			if (set.size() != 9)
				rowIsFilled = false;
		}
	}
}