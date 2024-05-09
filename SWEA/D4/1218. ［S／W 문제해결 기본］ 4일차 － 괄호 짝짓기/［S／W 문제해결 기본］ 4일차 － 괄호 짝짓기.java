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

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 테케 길이

			String str = br.readLine();

			Stack<Character> st = new Stack();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == ')' && st.peek() == '(')
					st.pop();
				else if (c == ']' && st.peek() == '[')
					st.pop();
				else if (c == '}' && st.peek() == '{')
					st.pop();
				else if (c == '>' && st.peek() == '<')
					st.pop();
				else
					st.push(c);

			}
			if (st.isEmpty())
				System.out.println("#" + test_case + " " + 1);
			else
				System.out.println("#" + test_case + " " + 0);
		}
	}
}