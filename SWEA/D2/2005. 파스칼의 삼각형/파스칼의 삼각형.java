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

		int tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			arr[0][0] = 1;

			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i + 1; j++) {
					if (j == 0 || j == i)
						arr[i][j] = 1;
					else
						arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				}
			}
			System.out.println("#" + test_case);
			for (int[] i : arr) {
				for (int j : i) {
					if (j != 0)
						System.out.print(j + " ");
				}
				System.out.println();
			}
		}
	}
}