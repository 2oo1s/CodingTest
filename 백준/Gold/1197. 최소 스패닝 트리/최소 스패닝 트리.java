import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int[] parent;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];
		graph = new int[E][3];
		for (int i = 1; i <= V; i++)
			parent[i] = i;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}

		// 가중치 오름차순으로 정렬
		Arrays.sort(graph, (x, y) -> x[2] - y[2]);

		// 같은 집합이 아닌 링크 v-1개를 선택
		int ans = 0, cnt = 0;
		for (int i = 0; i < E; i++) {
			// 같은 집합이 아닌(사이클이 아닌) 간선 선택
			if (find(graph[i][0]) != find(graph[i][1])) {
				union(graph[i][0], graph[i][1]);
				ans += graph[i][2];
				// V-1개의 간선을 선택하면 종료
				if (++cnt == V - 1)
					break;
			}
		}
		System.out.println(ans);
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
