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
			st = new StringTokenizer(br.readLine(), " ");

			int p = Integer.parseInt(st.nextToken()); // 1리터당 a사 수도 요금
			int q = Integer.parseInt(st.nextToken()); // b회사 기본 요금
			int r = Integer.parseInt(st.nextToken()); // 기본요금 청구되는 기준
			int s = Integer.parseInt(st.nextToken()); // r리터 초과하면 리터당 요금
			int w = Integer.parseInt(st.nextToken()); // 종민이가 사용하는 수도의 양

			int fee = 0;

			// a사 요금을 초기 요금으로 설정
			fee = p * w;

			// b사 요금 확인
			if (w <= r)
				fee = Math.min(fee, q);
			else {
				int temp = q;
				temp += (w - r) * s;
				fee = Math.min(fee, temp);
			}

			System.out.println("#" + test_case + " " + fee);
		}
	}
}