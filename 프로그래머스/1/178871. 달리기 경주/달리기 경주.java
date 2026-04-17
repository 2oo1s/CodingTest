import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> ranking = new HashMap<>();
        
        // 선수이름이 키값
        for (int i = 0; i < players.length ; i++) 
        {
            ranking.put(players[i], i);
        }

        for (String player : callings)
        {
            // 플레이어 순위 저장
            int playerRanking = ranking.get(player);
            
            // 앞선 선수 늦추기
            String frontPlayer = players[playerRanking - 1];
            
            ranking.replace(frontPlayer, playerRanking);  
            players[playerRanking] = frontPlayer;   
            
            // 플레이어 순위 올리기
            ranking.replace(player, playerRanking - 1);
            players[playerRanking - 1] = player; 
        }
        
        return players;
    }
}