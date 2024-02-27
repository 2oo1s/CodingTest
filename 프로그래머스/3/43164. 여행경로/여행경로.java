import java.util.*;

class Solution {
    String[] answer;
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        // 항공권 알파벳순으로 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        dfs("ICN", "ICN", 0, tickets);
        
        return answer;
    }
    
    public boolean dfs(String start, String route, int cnt, String[][] tickets) {
        // 모든 티켓 사용한 경우
        if (cnt == tickets.length) {
            answer = route.split(",");
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start)) {
                if(!visited[i]){
                    visited[i] = true;

                    if (dfs(tickets[i][1], route + "," + tickets[i][1], cnt + 1, tickets))
                        return true;
                    visited[i] = false;
                 }
            }
        }
        return false;
    }
}