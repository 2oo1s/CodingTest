import java.util.*;

class Solution {
    static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        bfs(0,0, maps);
        if(maps[maps.length-1][maps[0].length-1]==1)
            return -1;
        else
            answer = maps[maps.length-1][maps[0].length-1];
        return answer;
    }
    
    public static void bfs(int i, int j, int[][] maps){
        Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] { i, j });
		visited[i][j] = true;
        
        while(!q.isEmpty()){
            Integer[] t = q.poll();
            for(int k = 0; k < 4; k++){
                int x = t[0] + dx[k];
                int y = t[1] + dy[k];
               if (x >= 0 && y >= 0 && x < visited.length && y < visited[0].length) {
					if (maps[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						maps[x][y] =  maps[t[0]][t[1]] + 1;
						q.add(new Integer[] { x, y });
					}
				}
            }
        }
    }
}