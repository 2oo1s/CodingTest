import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] board;
	static boolean[][] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(br.readLine());

			board = new int[16][16];
			visited = new boolean[16][16];

			int x = 0, y = 0;
			int arriveX = 0, arriveY = 0;

			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					board[i][j] = str.charAt(j) - '0';
					if (board[i][j] == 2) {
						x = i;
						y = j;
					}
					if (board[i][j] == 3) {
						arriveX = i;
						arriveY = j;
					}
				}
			}

			bfs(x, y);

			if (board[arriveX][arriveY] == -1)
				System.out.println("#" + tc + " 1");
			else
				System.out.println("#" + tc + " 0");
		}
	}

	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();

		visited[i][j] = true;
		q.add(new int[] { i, j });

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int k = 0; k < 4; k++) {
				int nx = pos[0] + dx[k];
				int ny = pos[1] + dy[k];

				if (nx >= 0 && nx < 16 && ny >= 0 && ny < 16) {
					if (board[nx][ny] == 3) {
						board[nx][ny] = -1;
						break;
					}
					if (!visited[nx][ny] && board[nx][ny] == 0) {
						q.add(new int[] { nx, ny });
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
}