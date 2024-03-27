import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }
        // System.out.println(Arrays.deepToString(graph));
        bfs(1);
    }

    public static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visited[next] && dist[next] > dist[cur] + 1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        int far = Integer.MIN_VALUE;    // 최대한 멀리 있는 헛간까지의 거리
        int farV = -1;
        int cnt = 1;    // far만큼의 거리에 있는 헛간 수

        for (int i = 1; i <= n; i++) {
            if (far < dist[i]) {
                far = dist[i];
                farV = i;
                cnt = 1;
            } else if (far == dist[i])
                cnt++;
        }
        System.out.println(farV + " " + far + " " + cnt);
    }
}