import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] temp = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++)
            temp[i] = Integer.parseInt(arr[i]);
        
        Arrays.sort(temp);
        
        answer += String.valueOf(temp[0]) + " " + String.valueOf(temp[temp.length - 1]);
    
        
        return answer;
    }
}