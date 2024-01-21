import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] board;
    static boolean[][] visited;
    static int N;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 0;

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            board = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            tc++;
            dfs();

            System.out.println("Problem " + tc + ": " + ans);
        }
    }

    public static void dfs() {
        int[][] costs = new int[N][N];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, board[0][0]));
        costs[0][0] = board[0][0];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int start = now.start;
            int end = now.end;
            int cost = now.cost;

            for (int k = 0; k < 4; k++) {
                int nx = start + dx[k];
                int ny = end + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        costs[nx][ny] = cost + board[nx][ny];
                        pq.add(new Node(nx, ny, cost + board[nx][ny]));
                    }
                }
            }
        }
        ans = costs[N - 1][N - 1];
    }
}

class Node implements Comparable<Node> {
    int start;
    int end;
    int cost;

    public Node(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}