import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < operations.length; i++) {
            String[] cmd = operations[i].split(" ");
            
            if(cmd[0].equals("D") && pq.isEmpty())
                continue;
            
            if(cmd[0].equals("I")) {
                pq.add(Integer.parseInt(cmd[1]));
                maxPq.add(Integer.parseInt(cmd[1]));
                continue;
            }
            
            if(cmd[1].equals("-1")) {
                int min = pq.poll();
                maxPq.remove(min);
                continue;
            }
            
            if(cmd[1].equals("1")) {
                int max = maxPq.poll();
                pq.remove(max);
                continue;
            }
        }
        
        if(!pq.isEmpty()) {
            answer[0] = maxPq.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}