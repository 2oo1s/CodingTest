import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int n;
	static int board[];
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tc; i++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n]; // 행은 idx, 열은 값으로 표현
			answer = 0;

			promising(0);

			System.out.println("#" + i + " " + answer);
		}
	}

	public static void promising(int depth) {
		boolean flag;

		if (depth == n) {
			answer++;
			return;
		}

		for (int i = 0; i < n; i++) {
			flag = true;
			board[depth] = i;

			for (int j = 0; j < depth; j++) {
				// 겹치는 열과 대각선 없는지 확인
				if (board[j] == board[depth] || Math.abs(depth - j) == Math.abs(board[depth] - board[j])) {
					flag = false;
					break;
				}
			}

			if (flag)
				promising(depth + 1);
		}
	}
}