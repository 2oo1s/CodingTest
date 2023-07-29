import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] num = new long[N];
		long[] C = new long[M];
		long answer = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < N; i++)
			num[i] += num[i - 1];
		for (int i = 0; i < N; i++) { // 합배열의 모든 값에 %연산 수행하기
			int remainder = (int) (num[i] % M);
			if (remainder == 0)
				answer++; // 0~i까지의 구간합 자체가 0인 경우 정답에 더해주기
			C[remainder]++; // 같은 나머지를 가진 인덱스의 개수 카운팅 해주기
		}
		for (int i = 0; i < M; i++) {
			if (C[i] > 1) {
				answer += (C[i] * (C[i] - 1) / 2); // 같은 나머지를 가진 인덱스들중 2개를 뽑는 경우의 수를 더해주기
			}
		}
		System.out.println(answer);
	}
}