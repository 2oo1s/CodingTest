import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E, K;
    static ArrayList<Edge> graph[];
    static boolean[] visited;
    static int[] dist;
    static PriorityQueue<Edge> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        dist = new int[V + 1];
        q = new PriorityQueue<>();

       for (int i = 0; i <= V; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i <= V; i++)
            dist[i] = Integer.MAX_VALUE;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
        }
        q.add(new Edge(K, 0));
        dist[K] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();
            int curVertex = cur.vertex;

            if (!visited[curVertex]) {
                visited[curVertex] = true;
                for (int i = 0; i < graph[curVertex].size(); i++) {
                    Edge temp = graph[curVertex].get(i);

                    int nextV = temp.vertex;
                    int value = temp.value;

                    if (dist[nextV] > dist[curVertex] + value) {
                        dist[nextV] = dist[curVertex] + value;
                        q.add(new Edge(nextV, dist[nextV]));
                    }
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
        int vertex, value;  // 연결된 정점, 가중치 저장

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e) {
            return this.value - e.value;
        }
    }
}