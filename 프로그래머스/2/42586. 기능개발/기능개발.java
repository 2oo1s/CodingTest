import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) 
                q.add((100 - progresses[i]) / speeds[i]);
            else
                q.add((100 - progresses[i]) / speeds[i] + 1);
        }
        
        int temp = q.poll();
        int cnt = 1;
        
        while(!q.isEmpty()) {
            if(temp >= q.peek()) {
                cnt += 1;
                q.poll();
            } else {
                list.add(cnt);
                temp = q.poll();
                cnt = 1;
            }
        }
        list.add(cnt);
        
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}