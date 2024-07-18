import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<Integer[]> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int cnt = 1; cnt <= N; cnt++) {
			int n = Integer.parseInt(st.nextToken()); // 높이
			
			while (!stk.isEmpty() && n > stk.peek()[0]) {
				stk.pop();
			}

			if (stk.isEmpty())
				sb.append("0 ");
			else
				sb.append(stk.peek()[1] + " ");

			stk.push(new Integer[] { n, cnt });
		}
		System.out.println(sb);
	}
}