import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        int temp = -1; 
        
        for(int i = 0; i < arr.length; i++){
             if(arr[i] != temp){
                 list.add(arr[i]);
                 temp = arr[i];
             }else
                 continue;
        }
        
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = list.get(i); 
    
        return answer;
    }
}