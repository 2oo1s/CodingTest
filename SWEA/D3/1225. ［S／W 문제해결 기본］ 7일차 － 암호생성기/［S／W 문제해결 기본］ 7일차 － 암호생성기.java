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

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<>();

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 8; i++)
				q.add(Integer.parseInt(st.nextToken()));

			boolean flag = false;

			while (!flag) {
				// 1 사이클
				for (int i = 1; i <= 5; i++) {
					int temp = q.poll();
					temp -= i;
					if (temp <= 0) {
						temp = 0;
						q.add(temp);
						flag = true;
						break;
					}
					q.add(temp);
				}
			}
			System.out.print("#" + tc + " ");
			for (int i : q)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}