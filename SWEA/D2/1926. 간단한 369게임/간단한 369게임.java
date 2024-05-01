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
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String target = String.valueOf(i);
			String[] str = target.split("");
			int cnt = 0;

			for (String s : str) {
				if (s.equals("3") || s.equals("6") || s.equals("9"))
					cnt += 1;
			}

			if (cnt > 0) {
				while (cnt > 0) {
					sb.append("-");
					cnt--;
				}
				sb.append(" ");
			} else
				sb.append(target).append(" ");
		}
		System.out.print(sb);
	}
}