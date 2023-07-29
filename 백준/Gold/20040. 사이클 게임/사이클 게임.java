import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] board;
	static int[] parent;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken()); // 점의 개수
		m = Integer.parseInt(st.nextToken()); // m 번째
		board = new int[m][2];
		parent = new int[n + 1];
		cnt = new int[n + 1];

		boolean end = false;

		// 부모 초기화
		for (int i = 1; i <= n; i++)
			parent[i] = i;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			if (find(parent[board[i][0]]) != find(board[i][1])) {
				union(board[i][0], board[i][1]);
			} else {
				end = true;
				System.out.println(i + 1);
				break;
			}
		}
		if (!end)
			System.out.println(0);
	}

	public static void union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		if (n1 != n2) {
			parent[n2] = n1;
			cnt[n1]++;
		}
	}

	public static int find(int n1) {
		if (parent[n1] == n1)
			return n1;
		return parent[n1] = find(parent[n1]);
	}
}