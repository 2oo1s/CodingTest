import java.util.*;

class Solution {
    static int n, m;
    static int[] oil;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;

    public int solution(int[][] land) {
        int answer = 0;

        n = land.length;
        m = land[0].length;
        oil = new int[m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j])
                    bfs(land, i, j);
            }
        }

        for (int i : oil)
            answer = Math.max(answer, i);

        return answer;
    }

    public void bfs(int[][] land, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        visited[x][y] = true;
        q.add(new int[]{x, y});

        int cnt = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            set.add(cur[1]);

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (land[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        cnt += 1;
                    }
                }
            }
        }

        for (int idx : set) 
            oil[idx] += cnt;
    }
}