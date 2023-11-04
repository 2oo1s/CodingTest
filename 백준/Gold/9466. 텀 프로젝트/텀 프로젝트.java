import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static boolean[] isCycle;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			answer = 0;
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			isCycle = new boolean[n + 1]; // 싸이클을 형성했는지 안했는지 확인용 ... 팀을 이뤘다는게 결국 싸이클

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				if (arr[j] == j) {
					isCycle[j] = true;
					answer++;
				}
			}

			for (int j = 1; j <= n; j++) {
				if (isCycle[j])
					continue;
				dfs(j);
			}
			System.out.println(n - answer);
		}
	}

	public static void dfs(int idx) {
		if (visited[idx])
			return;

		visited[idx] = true;
		int next = arr[idx];

		if (!visited[next]) // 다음 노드가 방문된 노드라면, dfs로 들어오게 된 부모 노드일 경우
			dfs(next);
		else {
			if (!isCycle[next]) { // 싸이클 형성되는데 아직 싸이클 형성 안했다는거
				answer++;
				while (next != idx) {
					answer++;
					next = arr[next];
				}
			}
		}
		isCycle[idx] = true;
	}
}
