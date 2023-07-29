// 20분
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 업뎃되는 스코빌 지수 자동 정렬
        
        for(int i : scoville)
            pq.add(i);
        
        while(true){
            // 스코빌 지수 하나 있는데, K보다 작을 때는 더이상 스코빌 섞는거 불가능 -> -1 출력
            if(pq.size()==1){
                if(pq.peek()<K)
                    return -1;
            }
            /*
            가장 작은 스코빌 지수가 K보다 작을 때는,
            처음 
            */
            if(pq.peek() < K){
                pq.add(pq.poll() + pq.poll() * 2);
                answer++;
            }
            else
                break;
        }
        return answer;
    }
}