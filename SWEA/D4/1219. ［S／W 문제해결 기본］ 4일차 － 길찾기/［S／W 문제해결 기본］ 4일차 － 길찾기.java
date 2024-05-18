import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int size = 100;
	static int[][] arr;
	static int answer;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			arr = new int[size][2];
			answer = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				if (arr[from][0] != 0)
					arr[from][1] = to;
				else
					arr[from][0] = to;
			}

			dfs(arr[0][0]);
			dfs(arr[0][1]);

			System.out.println("#" + t + " " + answer);
		}
	}

	public static void dfs(int v) {
		if (v == 0)
			return;

		if (v == 99) {
			answer = 1;

			return;
		}

		dfs(arr[v][0]);
		dfs(arr[v][1]);
	}
}