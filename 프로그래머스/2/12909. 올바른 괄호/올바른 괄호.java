import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        
        for(int i = 0; i < c.length; i++) {
            if(c[i] == ')') {
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else {
                    answer = false;
                    break;
                }   
            } else 
                stack.push(c[i]);
        }
        if(stack.size() != 0 && stack.peek() == '(')
            answer = false;
        
        return answer;
    }
}