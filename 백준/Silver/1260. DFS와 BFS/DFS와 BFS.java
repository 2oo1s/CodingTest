import java.io.*;
import java.util.*;

public class Main {
    
	static int N, M, V;
	static ArrayList<Integer> adjL[];
	static boolean[] visited;
	static StringBuilder answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		answer = new StringBuilder();

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개
		V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

		adjL = new ArrayList[N + 1]; // 정점 번호 1 ~ N
		for (int i = 0; i <= N; i++) {
			adjL[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adjL[s].add(e);
			adjL[e].add(s);
		}
		// System.out.println(Arrays.deepToString(adjL));

		// 여러노드가 연결된 경우 숫자가 작은 노드부터 탐색
		for (int i = 1; i <= N; i++) {
			adjL[i].sort(null);
		}

		visited = new boolean[N + 1];

		dfs(V);
		answer.append("\n");
		bfs(V);

		System.out.println(answer);
	}

	public static void dfs(int v) {
		visited[v] = true;
		answer.append(v).append(" ");

		for (int j : adjL[v]) {
			if (!visited[j])
				dfs(j);
		}
	}

	public static void bfs(int v) {
		visited = new boolean[N + 1]; // 방문 노드 정보 초기화
		Queue<Integer> q = new LinkedList<>();

		visited[v] = true;
		q.add(v);
		answer.append(v).append(" ");

		while (!q.isEmpty()) {
			int c = q.poll();

			for (int j : adjL[c]) {
				if (!visited[j]) {
					q.add(j);
					visited[j] = true;
					answer.append(j).append(" ");
				}
			}
		}
	}
}
