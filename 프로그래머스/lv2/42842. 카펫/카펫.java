import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        int size = brown + yellow;  // 전체 넓이
        int w = 0, h = 0;
        
        for(int i = 3; i <= size; i++){
            int temp = size / i;
            if(size % temp == 0 && size % i == 0){
                w = Math.max(i, temp);
                h = Math.min(i, temp);
                
                if((w-2)*(h-2) == yellow){
                    answer[0] = w;
                    answer[1] = h;
                }
            }
        }
        return answer;
    }
}