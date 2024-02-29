import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Double> map = new HashMap<>();
        
        Arrays.sort(stages);
        
        int pastStage = 0;
        
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] > N)
                continue;
            if(pastStage != stages[i])
                pastStage = stages[i];
            else
                continue;
            
            int same = 0;
            int tot = 0;
            
            for(int j = i; j < stages.length; j++) {
                if(stages[i] <= stages[j]) {
                    tot++;
                    if(stages[i] == stages[j])
                        same++;
                }
            }
            // System.out.println(stages[i] + " : " + same + " : " + tot + " : " + (double)same/tot);
            map.put(stages[i], (double)same/tot);
        }

        for(int i = 1; i <= N; i++) {
            if(!map.containsKey(i))
                map.put(i, 0.0);
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        // value 기준으로 오름차순 정렬
		Collections.sort(keys, (v1, v2) -> (map.get(v2).compareTo(map.get(v1)))); 
        
        for(int i = 0; i < N; i++)
            answer[i] = keys.get(i);
        
        return answer;
    }
}