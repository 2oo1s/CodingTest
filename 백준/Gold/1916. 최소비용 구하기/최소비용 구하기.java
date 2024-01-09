import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<City> graph[];
    static boolean[] visited;
    static int[] dist;
    static PriorityQueue<City> q;
    static int sCity, eCity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 도시
        M = Integer.parseInt(br.readLine());    // 버스

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        q = new PriorityQueue<>();

        for (int i = 0; i < N; i++)
            graph[i + 1] = new ArrayList<>();

        for (int i = 0; i <= N; i++)
            dist[i] = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[s].add(new City(e, v));
        }
        st = new StringTokenizer(br.readLine(), " ");

        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());

        dist[sCity] = 0;

        q.add(new City(sCity, 0));

        while (!q.isEmpty()) {
            City cur = q.poll();
            int curV = cur.city;

            if (visited[curV])
                continue;

            visited[curV] = true;

            for (int i = 0; i < graph[curV].size(); i++) {
                City temp = graph[curV].get(i);

                int next = temp.city;
                int cost = temp.cost;

                if (dist[next] > dist[curV] + cost) {
                    dist[next] = dist[curV] + cost;
                    q.add(new City(next, dist[next]));
                }
            }
        }
        System.out.println(dist[eCity]);
    }

    static class City implements Comparable<City> {
        int city, cost;

        public City(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(City c) {
            if (this.cost > c.cost)
                return 1;
            else
                return -1;
        }
    }
}