import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M];

        int x = 0, y = 0;

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = temp.charAt(j);
                if (board[i][j] == 'I') {
                    x = i;
                    y = j;
                    visited[i][j] = true;
                }
            }
        }
        // System.out.println(Arrays.deepToString(board));
        bfs(x, y);

        if (answer == 0)
            System.out.println("TT");
        else
            System.out.println(answer);
    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{x, y});

        while (!q.isEmpty()) {
            Integer[] temp = q.poll();
            int i = temp[0];
            int j = temp[1];

            for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] != 'X') {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Integer[]{nx, ny});
                        if (board[nx][ny] == 'P')
                            answer += 1;
                    }
                }
            }
        }
    }
}
