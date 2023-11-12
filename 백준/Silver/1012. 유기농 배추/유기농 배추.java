import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            board = new int[M][N];
            visited = new boolean[M][N];

            answer = 0;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                board[s][e] = 1;
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && board[i][j] == 1)
                        bfs(i, j);
                }
            }
            System.out.println(answer);
        }
    }

    public static void bfs(int i, int j) {
        visited[i][j] = true;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{i, j});

        while (!q.isEmpty()) {
            Integer[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!visited[nx][ny] && board[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new Integer[]{nx, ny});
                    }
                }
            }
        }
        answer += 1;
    }
}
