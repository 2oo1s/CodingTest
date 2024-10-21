class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int games = diffs.length;   // 게임 횟수
        long time = 0;
        
        int left = 0;
        int right = 100000;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            time = 0;

            for (int i = 0; i < games; i++) {
                int diff = diffs[i];    // 현재 퍼즐 난이도

                if (diff > mid) {  // 난이도가 더 어려우면
                    if (i > 0) 
                        time += ((times[i - 1] + times[i]) * (diff - mid)) + times[i]; 
                } else 
                    time += times[i];

                if(time > limit)
                    break;
            }
            
            if(time <= limit) {
                answer = mid;
                right = mid - 1;
            } else 
                left = mid + 1;
        }
        answer = answer == 0 ? 1 : answer;
        
        return answer;
    }

}