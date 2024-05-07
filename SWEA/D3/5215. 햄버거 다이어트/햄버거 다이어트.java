import java.util.*;
import java.io.*;

class Solution
{
	static int[][] arr;
	static int N;
	static int L;
	static int maxScore;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int T = Integer.parseInt(st.nextToken());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            maxScore=0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
                
				arr[i][0] = Integer.parseInt(st.nextToken());	// 점수
				arr[i][1] = Integer.parseInt(st.nextToken());	// 칼로리
			}
			
			dfs(0,0,0);

			System.out.println("#" + test_case + " " + maxScore);
		}
	}
	
	public static void dfs(int n, int score, int cal) {
		//부분집합으로 구한 누적된 칼로리수가 입력받은 제한보다 높을때 탐색끝
		if(cal > L)
			return;
        
        if(n == N) {
            if(maxScore < score)
                maxScore = Math.max(score, maxScore);
			return;
		}
		//더이상 트리에서 탐색할 다음 노드가 없을때 탐색 끝
		
		dfs(n+1, score+arr[n][0], cal + arr[n][1]);
		dfs(n+1, score, cal);
	}
}