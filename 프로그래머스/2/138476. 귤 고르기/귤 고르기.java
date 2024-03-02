import java.util.*;

class Solution {
    static HashMap<Integer, Integer> map;
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) 
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        for(Integer i : list){
            k -= i;
            answer++;
            if(k < 1) 
                return answer;
        }
        return answer;
    }
}