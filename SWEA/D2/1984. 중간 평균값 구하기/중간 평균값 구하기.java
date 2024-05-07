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

		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine(), " 	");

			int answer = 0;
			double sum = 0;
			int[] arr = new int[10];
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
				sum += arr[i];
			}

			sum -= (max + min);
			answer = (int) Math.round(sum / 8);

			System.out.println("#" + test_case + " " + answer);
		}
	}
}