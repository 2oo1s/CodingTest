import java.util.*;

class Solution {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public int solution(int[][] maps) {
		int answer = 0;
		visited = new boolean[maps.length][maps[0].length];
		bfs(0, 0, maps);

		answer = maps[maps.length - 1][maps[0].length - 1];
		if (answer == 1)
			return -1;
		else
			return answer;
	}

	public void bfs(int x, int y, int[][] maps) {
		visited[x][y] = true;
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] { x, y });

		while (!q.isEmpty()) {
			Integer[] t = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = t[0] + dx[i];
				int ny = t[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length) {
					if (!visited[nx][ny] && maps[nx][ny] != 0) {
						visited[nx][ny] = true;
						q.add(new Integer[] { nx, ny });
						maps[nx][ny] = maps[t[0]][t[1]] + 1;
					}
				}
			}
		}
	}
}