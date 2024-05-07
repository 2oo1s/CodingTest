import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
		public static class Student {
		int idx;
		double tot;

		public Student(int idx, double tot) {
			this.idx = idx;
			this.tot = tot;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		String[] score = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine(), " 	");

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			ArrayList<Student> students = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " 	");

				int mid = Integer.parseInt(st.nextToken());
				int fin = Integer.parseInt(st.nextToken());
				int hw = Integer.parseInt(st.nextToken());

				double sum = mid * 0.35 + fin * 0.45 + hw * 0.2;

				students.add(new Student(i, sum));
			}

			Collections.sort(students, new Comparator<Student>() {
				@Override
				public int compare(Student s1, Student s2) {
					return Double.compare(s2.tot, s1.tot);
				}
			});

			int rank = 0; // 몇번째 순위인지
			for (int i = 1; i <= students.size(); i++) {
				if (students.get(i).idx == k) {
					rank = i;
					break;
				}
			}

			rank = rank / (n / 10);
			System.out.println("#" + test_case + " " + score[rank]);
		}
	}
}