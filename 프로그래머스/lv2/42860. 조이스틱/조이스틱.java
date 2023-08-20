import java.util.*;

class Solution {
	public int solution(String name) {
		int answer = 0;

		int move = name.length() - 1; // 오른쪽으로 움직이는 횟수
		for (int i = 0; i < name.length(); i++) {
			// A와 Z 중에 더 가까운 쪽으로부터 접근
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
			int next = i + 1;
			while (next < name.length() && name.charAt(next) == 'A') {
				next++;
			}
			move = Math.min(move, i+(name.length()-next)+Math.min(i,name.length()-next));
		}
		return answer + move;
	}
}