import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] parent;
	static int[] route;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		parent = new int[N + 1];
		route = new int[M + 1];

		for (int i = 0; i <= N; i++)
			parent[i] = i;

		// 도시 정보
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++)
			route[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				if (arr[i][j] == 1)
					union(i, j);
		}

		int s = find(route[1]);
		for (int i = 2; i <= M; i++) {
			if (find(route[i]) != s) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	public static void union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);

		if (n1 != n2)
			parent[n2] = n1;
	}

	public static int find(int n1) {
		if (n1 == parent[n1])
			return n1;
		else
			return parent[n1] = find(parent[n1]);
	}
}
