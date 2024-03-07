import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ans = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        for (int i = 1; i <= n; i++)
            graph[i].sort(null);

        dfs(v);
        ans.append("\n");
        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(ans);
    }

    public static void dfs(int v) {
        visited[v] = true;
        ans.append(v).append(" ");

        for (int i : graph[v]) {
            if (!visited[i])
                dfs(i);
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        ans.append(v).append(" ");

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i : graph[temp]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    ans.append(i).append(" ");
                }
            }
        }
    }
}