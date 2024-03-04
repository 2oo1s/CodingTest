class Solution {
    static int join = 0;
    static int profit = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] sales = new int[emoticons.length];
        
        comb(0, sales, users, emoticons);
        
        answer[0] = join;
        answer[1] = profit;
        
        return answer;
    }
    
    public void comb(int idx, int[] sales, int[][] users, int[] emoticons) {
        if(idx == sales.length) {
            calc(sales, users, emoticons);
            return;
        }
        
        for(int i = 10; i<= 40; i += 10) {
            sales[idx] = i;
            comb(idx + 1, sales, users, emoticons);
        }
    }
    
    public void calc(int[] sales, int[][] users, int[] emoticons) {
        int tempJoin = 0;
        int tempProfit = 0;
        
        for(int[] user : users) {
            int ratio = user[0];
            int maxValue = user[1];
            
            int sum = 0;
            
            for(int i = 0; i < emoticons.length; i++) {
                if(sales[i] >= ratio)
                    sum += emoticons[i] * ((double)(100 - sales[i]) / 100);
            } // for emoticon문
            
            if(sum >= maxValue)
                tempJoin += 1;
            else
                tempProfit += sum;
        } // for user문
        
        if(tempJoin > join){
            join = tempJoin;
            profit = tempProfit;
        }
        else if(tempJoin == join)
            if(tempProfit > profit)
                profit = tempProfit;
    }
}