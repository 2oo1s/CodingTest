class Solution {
	static int cnt;
	static int N;

	public int solution(int[] numbers, int target) {
		N = numbers.length;
		cnt = 0;
		dfs(numbers, 0, 0, target);

		return cnt;
	}

	public static void dfs(int[] numbers, int n, int sum, int target) {
		if (n == N) {
			if (sum == target) {
				cnt++;
				return;
			}
		} else {
			dfs(numbers, n + 1, sum + numbers[n], target);
			dfs(numbers, n + 1, sum - numbers[n], target);
		}
	}
}