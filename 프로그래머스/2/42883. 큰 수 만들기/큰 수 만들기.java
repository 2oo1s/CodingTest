import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for(char c : number.toCharArray()){
            while (!stack.empty() && stack.peek() < c && k > 0){
                stack.pop();
                k--;
            }
            stack.add(c);
        }

        for(int i = 0; i < result.length; i++)
            result[i] = stack.get(i);
        
        return new String(result);
    }
}