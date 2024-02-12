import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> s = new Stack<>();
        
        for(int i : arr) {
            if(s.isEmpty())
                s.push(i);
            else {
                if(s.peek() != i)
                    s.push(i);
            }
        }
        answer = new int[s.size()];
        
        for(int i = answer.length - 1; i >= 0; i--)
            answer[i] = s.pop();

        return answer;
    }
}