import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		int diff = Integer.MAX_VALUE;
		int s = 0;
		int e = N - 1;

		int ans1 = 0;
		int ans2 = 0;

		while (s < e) {
			int temp = arr[s] + arr[e];
			int absValue = Math.abs(temp);

			if (absValue < diff) {
				diff = absValue;
				ans1 = arr[s];
				ans2 = arr[e];
				if (absValue == 0)
					break;
			}
			if (temp > 0)
				e-=1;
			else
				s+=1;
		}
		System.out.println(ans1 + " " + ans2);
	}

}
