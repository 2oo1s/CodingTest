import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int[] b = new int[m];
			int answer = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++)
				b[i] = Integer.parseInt(st.nextToken());

			if (n > m) {
				for (int i = 0; i < n - m + 1; i++) {
					int sum = 0;
					for (int j = 0; j < m; j++)
						sum += a[i + j] * b[j];

					answer = Math.max(answer, sum);
				}
			} else if (n < m) {
				for (int i = 0; i < m - n + 1; i++) {
					int sum = 0;
					for (int j = 0; j < n; j++)
						sum += a[j] * b[i + j];

					answer = Math.max(answer, sum);
				}
			} else {
				int sum = 0;
				for (int i = 0; i < n; i++)
					sum += a[i] * b[i];

				answer = Math.max(answer, sum);
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}
}