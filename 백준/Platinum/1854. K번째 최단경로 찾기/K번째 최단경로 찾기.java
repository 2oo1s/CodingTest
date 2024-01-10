import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<City>[] graph = new ArrayList[n + 1];
        // 1번부터 x번 도시까지의 거리 저장
        // 이동 경로 최대 k개까지 저장 가능하고, 이동 경로 내림차순으로 저장 -> 큐 맨 앞 값이 k번째 최단 경로가 되기 위해서
        // if 오름차순으로 저장할 경우, 큐 맨 앞 값이 최단 경로가 되므로 오름차순으로 저장해줘야됨
        PriorityQueue<Integer>[] distPq = new PriorityQueue[n + 1];
        PriorityQueue<City> q = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            distPq[i] = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
        }

        // 그래프 데이터 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new City(b, c));
        }
        q.add(new City(1, 0));
        distPq[1].add(0);

        while (!q.isEmpty()) {
            City cur = q.poll();
            int curV = cur.vertex;
            int cost = cur.cost;

            for (City next : graph[curV]) {
                if (distPq[next.vertex].size() < k) {
                    distPq[next.vertex].add(cost + next.cost);

                    q.add(new City(next.vertex, cost + next.cost));
                } else if (distPq[next.vertex].peek() > cost + next.cost) {
                    distPq[next.vertex].poll();
                    distPq[next.vertex].add(cost + next.cost);

                    q.add(new City(next.vertex, cost + next.cost));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (distPq[i].size() == k)
                System.out.println(distPq[i].peek());
            else
                System.out.println(-1);
        }
    }

    static class City implements Comparable<City> {
        int vertex, cost;

        public City(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(City c) {
            return this.cost - c.cost;
        }
    }
}