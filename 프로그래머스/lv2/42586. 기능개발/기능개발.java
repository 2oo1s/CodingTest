import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();

		// 각 기능별 완료되는 데 남은 일수 저장
		for (int i = 0; i < progresses.length; i++) {
			if ((100 - progresses[i]) % speeds[i] == 0)
				queue.add((100 - progresses[i]) / speeds[i]);
			else
				queue.add((100 - progresses[i]) / speeds[i] + 1);
		}

		int temp = queue.poll();
		int cnt = 1;

		while (!queue.isEmpty()) {
			if (temp >= queue.peek()) {
				cnt++;
				queue.poll();
			} else {
				list.add(cnt);
				cnt = 1;
				temp = queue.poll();
			}
		}
		list.add(cnt);
		
		answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i);

		return answer;
	}
}