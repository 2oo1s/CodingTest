import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(sc.next());
			int answer = 1;

			int n = sc.nextInt();
			int m = sc.nextInt();

			answer = multiple(n, m, answer);

			System.out.println("#" + test_case + " " + answer);
		}
	}

	public static int multiple(int n, int m, int ans) {
		if (m == 0)
			return ans;
		else
			return multiple(n, m - 1, ans * n);
	}
}