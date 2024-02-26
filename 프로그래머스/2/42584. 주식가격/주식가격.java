import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer[]> s = new Stack<>(); 
        
        for(int i = 0; i < prices.length; i++) {
            Integer[] tmp = {prices[i],i};
            
            if(s.empty()) {
                s.push(tmp);
                continue;
            }
            else { 
                while(s.peek()[0] > prices[i]){
                    answer[s.peek()[1]] = i - s.peek()[1];
                    s.pop();
                    
                    if(s.empty())
                        break;
                }
            }
            s.push(tmp);
        }
        while(!s.empty()) {
            answer[s.peek()[1]] = prices.length - s.peek()[1] - 1;
            s.pop();
        }
        return answer;
    }
}