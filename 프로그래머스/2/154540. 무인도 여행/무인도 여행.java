import java.util.*;

class Solution {
    static char[][] board;
    static boolean[][] visited;
    static int area = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Integer> cnt = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        int[] answer = {-1};
        board = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++)
                board[i][j] = maps[i].charAt(j);
        }
        // System.out.println(Arrays.deepToString(board));
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(!visited[i][j] && board[i][j] != 'X') {
                    area = 0;
                    bfs(i, j);
                    //System.out.println(area);
                }
            }
        }
        
        if(cnt.size() != 0) {
            answer = new int[cnt.size()];
            for(int i = 0; i < cnt.size(); i++)
                answer[i] = cnt.get(i);
            
            Arrays.sort(answer);
            return answer;
        } else
            return answer;
    }
    
    public void bfs(int i, int j) {
        Queue<Integer[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new Integer[] {i, j});
        
        while(!q.isEmpty()) {
            Integer[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            
            visited[x][y] = true;
            area += board[x][y] - '0';
            
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if(nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length) {
                    if(!visited[nx][ny] && board[nx][ny] != 'X'){
                        visited[nx][ny] = true;
                        q.add(new Integer[] {nx, ny});
                    }
                }
            }
        }
        cnt.add(area);
    }
}