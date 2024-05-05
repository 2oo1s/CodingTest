import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int answer;
	static int[] dx = { 1, 0 }; // 오른쪽, 아래쪽으로만 확인
	static int[] dy = { 0, 1 };
	static int len;
	static char[][] board;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			len = Integer.parseInt(br.readLine());
			board = new char[8][8];
			answer = 0;

			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++)
					board[i][j] = str.charAt(j);
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++)
					isValid(i, j);
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}

	// len 길이만큼 단어가 글자판 범위 안에 존재하는지
	public static void isValid(int i, int j) {
		for (int k = 0; k < 2; k++) {
			int ex = i + len * dx[k];
			int ey = j + len * dy[k];

			if (ex >= 0 && ex <= 8 && ey >= 0 && ey <= 8)
				palindrome(i, j, k); // 어느 방향으로 갈 수 있는지도 제공
		}
	}

	public static void palindrome(int i, int j, int k) {
		boolean flag = true;
		char[] temp = new char[len];

		for (int l = 0; l < len; l++) {
			int nx = i + l * dx[k];
			int ny = j + l * dy[k];

			temp[l] = board[nx][ny];
		}

		int s = 0;
		int e = len - 1;

		while (s < e) {
			if (temp[s] == temp[e]) {
				s++;
				e--;
			} else {
				flag = false;
				break;
			}
		}
		if (flag)
			answer += 1;
	}
}