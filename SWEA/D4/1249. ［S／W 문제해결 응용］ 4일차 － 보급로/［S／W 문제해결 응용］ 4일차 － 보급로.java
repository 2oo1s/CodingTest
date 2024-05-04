import java.util.*;
import java.io.*;

class Solution
{
	static int n;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] board;
	static int[][] dist;
	static int answer = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			dist = new int[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++)
					board[i][j] = str.charAt(j) - '0';
			}

			for (int[] d : dist)
				Arrays.fill(d, Integer.MAX_VALUE);

			dist[0][0] = 0;
			bfs(0, 0);

			System.out.println("#" + test_case + " " + dist[n - 1][n - 1]);
		}
	}

	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					int nd = board[nx][ny] + cur[2];

					if (dist[nx][ny] > nd) { 
						dist[nx][ny] = nd;
						q.offer(new int[] { nx, ny, nd });
					}
				}
			}
		}
	}
}