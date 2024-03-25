import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static char[][] board = new char[5][5];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 5; j++)
                board[i][j] = temp.charAt(j);
        }
        // System.out.println(Arrays.deepToString(board));

        comb(new int[7], 0, 0);

        System.out.println(answer);
    }

    public static void comb(int[] list, int idx, int cnt) {
        if (idx == 7) {
            bfs(list);
            return;
        }

        if (cnt == 25)
            return;

        list[idx] = cnt;

        comb(list, idx + 1, cnt + 1);
        comb(list, idx, cnt + 1);
    }

    public static void bfs(int[] list) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[7];

        visited[0] = true;
        q.add(list[0]);

        int cnt = 1;
        int dasom = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();

            if (board[temp / 5][temp % 5] == 'S')
                dasom++;

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < 7; j++) {
                    int nextX = (temp / 5) + dx[i];
                    int nextY = (temp % 5) + dy[i];

                    if (nextX == (list[j] / 5) && nextY == (list[j] % 5) && !visited[j]) {
                        visited[j] = true;
                        q.add(list[j]);
                        cnt++;
                    }
                }
            }
        }
        if (dasom >= 4 && cnt == 7)
            answer++;
    }
}