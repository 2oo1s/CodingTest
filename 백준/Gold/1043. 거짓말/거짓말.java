import java.io.*;
import java.util.*;

public class Main {
	static int N, M, P;
	static int[] parent;
	static int[] know;
	static ArrayList<Integer>[] party;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 진실을 아는 사람 정보 저장
		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		know = new int[P];
		for (int i = 0; i < P; i++)
			know[i] = Integer.parseInt(st.nextToken());

		// 부모 노드 초기화
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		// 파티 정보 저장
		party = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// System.out.println(Arrays.deepToString(party));
			party[i] = new ArrayList<Integer>();
			int attend = Integer.parseInt(st.nextToken());
			// 파티 참석하는 사람들 저장
			for (int j = 0; j < attend; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		// 같은 파티 가는 사람들 합치기
		for (int i = 0; i < M; i++) {
			// i번째 파티에 있는 첫번째 사람 저장
			int first = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++)
				// 첫번째 참가자 이후부터 합치기
				union(first, party[i].get(j));
		}
		// System.out.println(Arrays.deepToString(party));
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			boolean pass = true;
			int temp = find(party[i].get(0));
			for (int j = 0; j < know.length; j++) {
				if (temp == find(know[j])) {
					pass = false;
					break;
				}
			}
			if (pass)
				cnt += 1;
		}
		System.out.println(cnt);
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
