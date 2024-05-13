import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int n;
	static double e;
	static long answer;
	static long[] parent;
	static long[][] island;
	static ArrayList<Edge> edge;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			n = Integer.parseInt(br.readLine()); // 섬의 개수
			island = new long[n][2];
			parent = new long[n + 1];
			edge = new ArrayList<>();
			answer = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++)
				island[i][0] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++)
				island[i][1] = Integer.parseInt(st.nextToken());

			double e = Double.parseDouble(br.readLine()); // 환경 부담 세율

			for (int i = 0; i <= n; i++)
				parent[i] = i;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					double dist = Math.pow(island[i][0] - island[j][0], 2) + Math.pow(island[i][1] - island[j][1], 2);
					edge.add(new Edge(dist, i, j));
				}
			}

			Collections.sort(edge);

			for (Edge ed : edge) {
				if (find(ed.from) != find(ed.to)) {
					union(ed.from, ed.to);
					answer += ed.dist;
				}
			}
			System.out.println("#" + test_case + " " + Math.round(e * answer));
		}
	}

	static class Edge implements Comparable<Edge> {
		double dist;
		long from;
		long to;

		public Edge(double dist, long from, long to) {
			this.dist = dist;
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.dist > o.dist)
				return 1;
			else if (this.dist < o.dist)
				return -1;
			else
				return 0;
		}

	}

	public static void union(long n1, long n2) {
		n1 = find(n1);
		n2 = find(n2);

		if (n1 != n2)
			parent[(int) n2] = n1;
	}

	public static long find(long n1) {
		if (n1 == parent[(int) n1])
			return n1;
		else
			return parent[(int) n1] = find(parent[(int) n1]);
	}
}