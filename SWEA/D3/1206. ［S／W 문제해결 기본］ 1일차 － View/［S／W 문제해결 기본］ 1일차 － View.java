import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int answer = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			for (int i = 2; i < n - 2; i++) {
				int target = arr[i];
				int diff = target - Math.max(Math.max(Math.max(arr[i - 2], arr[i - 1]), arr[i + 1]), arr[i + 2]);
				if (diff > 0)
					answer += diff;
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}