class Solution {
    public int solution(int n) {
        int answer = 0;
        int oneCnt = Integer.bitCount(n);
        
        while(true) {
            n += 1;
            
            if(Integer.bitCount(n) == oneCnt)
                break;
            else
                continue;
        }
        answer = n;
        
        return answer;
    }
}