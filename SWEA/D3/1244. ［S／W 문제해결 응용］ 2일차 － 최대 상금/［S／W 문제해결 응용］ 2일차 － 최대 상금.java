import java.util.*;
import java.io.*;

class Solution {

	static char[] arr;
	static int max;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");

			String str = st.nextToken();
			int swap = Integer.parseInt(st.nextToken());
			arr = new char[str.length()];

			for (int i = 0; i < str.length(); i++)
				arr[i] = str.charAt(i);

			max = 0;

			dfs(0, 0, swap);

			System.out.println("#" + test_case + " " + max);
		}
	}

	public static void dfs(int k, int cnt, int swap) {
		if (cnt == swap) {
			StringBuilder sb = new StringBuilder();

			for (char i : arr)
				sb.append(i);
			max = Math.max(max, Integer.parseInt(sb.toString()));

			return;
		}

		for (int i = k; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				dfs(i, cnt + 1, swap);

				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
}