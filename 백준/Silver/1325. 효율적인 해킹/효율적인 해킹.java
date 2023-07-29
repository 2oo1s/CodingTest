import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dfs 시간 오래 걸림
public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		cnt = new int[N + 1];

		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<Integer>();
		//System.out.println(Arrays.deepToString(arr));
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
		}
		//System.out.println(Arrays.deepToString(arr));
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, cnt[i]);
		}
		// [3] 최대값을 갖는 노드 오름차순으로 출력
		// StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == max)
				System.out.print(i + " ");
		}
	}

	public static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
//		boolean[] v = new boolean[N+1];
		int[] v = new int[N + 1];

		q.add(s);
		v[s] = 1;

		while (!q.isEmpty()) {
			int c = q.poll();
			for (int n : arr[c]) {
				if (v[n] == 0) {
					q.add(n);
					v[n] = 1;
					cnt[n]++;
				}
			}
		}
	}
}
