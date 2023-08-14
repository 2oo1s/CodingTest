import java.util.*;
import java.io.*;

public class Main {
	static int T, F;
	static int[] parent;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine()); // 테케 수

		for (int i = 0; i < T; i++) {
			F = Integer.parseInt(br.readLine()); // 친구 관계 수

			cnt = new int[F * 2];
			Arrays.fill(cnt, 1);

			parent = new int[F * 2];
			for (int t = 0; t < F * 2; t++)
				parent[t] = t;

			HashMap<String, Integer> map = new HashMap<>(); // 이름, 인덱스

			int idx = 0;
			for (int j = 0; j < F; j++) {
				st = new StringTokenizer(br.readLine(), " ");

				// 친구 관계 입력
				String first = st.nextToken();
				String second = st.nextToken();

				// 해당 친구들 맵에 존재하지 않으면 추가
				if (!map.containsKey(first)) {
					map.put(first, idx++);
				}
				if (!map.containsKey(second)) {
					map.put(second, idx++);
				}

				// 각 친구들 idx로 유니온
				union(map.get(first), map.get(second));

				System.out.println(cnt[find(map.get(second))]);
			}
		}

	}

	public static int find(int n) {
		if (parent[n] == n)
			return n;
		return parent[n] = find(parent[n]);
	}

	public static void union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);

		if (n1 != n2) {
			parent[n2] = n1;
			// n1 자식으로 들어왔으니까 n2에 연결되어 있던 친구들도 n1에 연결되므로 관계 수 더해줌
			cnt[n1] += cnt[n2];
		}
	}
}
