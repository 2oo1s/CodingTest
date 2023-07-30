class Solution {
	static int answer;
	static int N;

	public int solution(int[] numbers, int target) {
		answer = 0;
		
		N = numbers.length;
		dfs(numbers, 0, 0, target);

		return answer;
	}

	public static void dfs(int[] numbers, int n, int sum, int target) {
		if (n == N) {
			if (sum == target) {
				answer++;
				return;
			}
		} else {
			dfs(numbers, n + 1, sum + numbers[n], target);
			dfs(numbers, n + 1, sum - numbers[n], target);
		}
	}
}
