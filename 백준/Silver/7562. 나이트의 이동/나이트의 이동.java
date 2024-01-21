import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] board;
    static int l;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int fy = Integer.parseInt(st.nextToken());
            int fx = Integer.parseInt(st.nextToken());

            bfs(y, x);
            //System.out.println(Arrays.deepToString(board));
            System.out.println(board[fy][fx]);
        }
    }

    public static void bfs(int j, int i) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{j, i});
        visited[j][i] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];

            for (int k = 0; k < 8; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (ny >= 0 && nx >= 0 && ny < l && nx < l) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                        board[ny][nx] = board[y][x] + 1;
                    }
                }
            }
        }
    }
}