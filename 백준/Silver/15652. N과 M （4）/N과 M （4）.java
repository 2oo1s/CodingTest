import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		dfs(0, 1);
		System.out.println(ans);
	}

	public static void dfs(int n, int s) {
		if (n == M) {
			for (int t : arr)
				ans.append(t).append(" ");
			ans.append("\n");
			return;
		}
		// [1] 하부 호출
		for (int j = s; j <= N; j++) {
			arr[n] = j; // 선택한 숫자 저장(출력위해서)
			dfs(n + 1, j); // 다음숫자 선택하러 하부 호출
		}
	}
}
