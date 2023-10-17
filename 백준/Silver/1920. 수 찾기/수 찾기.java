

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] target = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++)
			target[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		for (int i = 0; i < M; i++) {
			boolean find = false;
			int t = target[i];
			int s = 0;
			int e = arr.length - 1;

			while (s <= e) {
				int midI = (s + e) / 2;
				int midV = arr[midI];

				if (midV > t)
					e = midI - 1;
				else if (midV < t)
					s = midI + 1;
				else {
					find = true;
					break;
				}
			}
			if (find)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

}
