import java.io.*;
import java.util.*;

public class Main {

    static int V, E, K; // 정점, 간선, 시작점
    static ArrayList<Edge> adjL[];  // 방향 그래프 저장
    static int dist[];  // 시작점으로부터 각 노드애 도달하는 거리 저장
    static boolean visited[];
    static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        adjL = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++)
            adjL[i] = new ArrayList<Edge>();

        for (int i = 1; i <= V; i++)
            dist[i] = Integer.MAX_VALUE;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());   // start
            int v = Integer.parseInt(st.nextToken());   // end
            int w = Integer.parseInt(st.nextToken());   // 가중치

            adjL[u].add(new Edge(v, w));
        }

        q.add(new Edge(K, 0));
        dist[K] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();
            int cur_v = cur.vertex;

            if (visited[cur_v])
                continue;

            visited[cur_v] = true;

            for (int i = 0; i < adjL[cur_v].size(); i++) {
                Edge temp = adjL[cur_v].get(i); // 순서대로 연결된 노드들 탐색
                int next = temp.vertex;
                int value = temp.value;

                if (dist[next] > dist[cur_v] + value) { // 더 적은 가중치로 도달 가능한 경우, 갱신
                    dist[next] = dist[cur_v] + value;
                    q.add(new Edge(next, dist[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (visited[i])
                System.out.println(dist[i]);
            else
                System.out.println("INF");
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex, value;
        public Edge(int v, int w) {
            this.vertex = v;
            this.value = w;
        }
        @Override
        public int compareTo(Edge o) {
            return value - o.value;
        }
    }
}