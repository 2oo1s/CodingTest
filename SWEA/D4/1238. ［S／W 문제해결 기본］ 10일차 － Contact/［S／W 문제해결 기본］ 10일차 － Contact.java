import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int n;
	static int[][] graph;
	static int[] visited;
	static int answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			answer = 0;

			n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			graph = new int[101][101];
			visited = new int[101];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from][to] = 1;
			}
			bfs(s);
			System.out.println("#" + test_case + " " +answer);
		}
	}

	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);

		int depth = 1;

		visited[v] = depth;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < 101; i++) {
				if (graph[curr][i] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = visited[curr] + 1;
				}
			}
			depth = Math.max(depth, visited[curr]);
		}

		for (int i = 100; i >= 0; i--) { // 가장 큰 사람 찾아야되니까 뒤에서부터 확인
			if (visited[i] == depth) {
				answer = i;
				break;
			}
		}
	}
}