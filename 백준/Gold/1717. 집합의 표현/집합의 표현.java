import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1]; // 초기의 집합 수

		for (int i = 0; i <= n; i++)
			parent[i] = i;
		// StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int op = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			if (op == 0) {
				union(n1, n2);
			} else {
				// sb.append((find(n1, n2) ? "yes" : "no") + "\n");
				if (find(n1, n2))
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
		// System.out.println(sb.toString());
	}

	public static void union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		if (n1 != n2) {
			parent[n2] = n1; // 같은 부모로 변경
		}
	}

	public static int find(int n1) {
		if (parent[n1] == n1)
			return n1;
		return parent[n1] = find(parent[n1]);
	}

	public static boolean find(int n1, int n2) {
		if (find(n1) == find(n2))
			return true;
		else
			return false;

	}
}
