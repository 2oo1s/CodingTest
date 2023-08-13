import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int pair;
	static ArrayList<Integer> com[];
	static boolean visited[];
	static int ans = 0; // 바이러스 걸리는 컴퓨터 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 컴퓨터 개수
		pair = Integer.parseInt(br.readLine()); // 연결 정보

		com = new ArrayList[N + 1]; // 컴퓨터 개수만큼 공간 할당
		visited = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++)
			com[i] = new ArrayList<Integer>(); // 각 공간마다 ArrayList 만들어주기

		for (int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			com[s].add(e);
			com[e].add(s);
		}
		bfs(1); // 1번 노드터 탐색

		System.out.println(ans);
		// System.out.println(Arrays.deepToString(com));
	}

	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = true;

		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i : com[temp]) {
				// 탐색 안 한 컴퓨터
				if (!visited[i]) {
					ans += 1;
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

}
