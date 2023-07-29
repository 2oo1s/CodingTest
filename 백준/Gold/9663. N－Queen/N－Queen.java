

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static boolean[] v1, v2, v3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		v1 = new boolean[2 * N];
		v2 = new boolean[2 * N];
		v3 = new boolean[2 * N];
		ans = 0;

		dfs(0);
		System.out.println(ans);

	}

	// n이 행 번호
	public static void dfs(int n) {
		if (n == N) {
			ans++;
			return;
		}
		for (int j = 0; j < N; j++) {
			if (!v1[j] && !v2[n + j] && !v3[n - j + N]) {
				v1[j] = v2[n + j] = v3[n - j + N] = true;
				dfs(n + 1);
				v1[j] = v2[n + j] = v3[n - j + N] = false;
			}
		}
	}
}
