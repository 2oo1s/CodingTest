class Solution {
	static int answer;
	static int N;
    static int T;
    
	public int solution(int[] numbers, int target) {
		answer = 0;
		T = target;
		N = numbers.length;
        
		dfs(numbers, 0, 0);

		return answer;
	}

	public static void dfs(int[] numbers, int n, int sum) {
		if (n == N) {
			if (sum == T) {
				answer++;
				return;
			}
		} else {
			dfs(numbers, n + 1, sum + numbers[n]);
			dfs(numbers, n + 1, sum - numbers[n]);
		}
	}
}