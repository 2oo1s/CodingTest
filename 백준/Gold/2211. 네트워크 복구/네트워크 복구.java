import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] graph;
    static ArrayList<Node> ans;
    static boolean[] visited;
    static int[] dist;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        pq = new PriorityQueue<>();
        ans = new ArrayList<>();

        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i <= N; i++)
            dist[i] = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(s, e, t));
            graph[e].add(new Node(e, s, t));
        }
        pq.add(new Node(1, 1, 0));
        visited[1] = true;
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!visited[cur.to]) {
                visited[cur.to] = true;
                ans.add(cur);
            }

            for (int i = 0; i < graph[cur.to].size(); i++) {
                Node next = graph[cur.to].get(i);

                if (dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    pq.add(new Node(next.from, next.to, dist[next.to]));
                }
            }
        }

        System.out.println(ans.size());
        for (Node node : ans)
            System.out.println(node.from + " " + node.to);
    }

    static class Node implements Comparable<Node> {
        int from, to, cost;

        Node(int start, int end, int cost) {
            this.from = start;
            this.to = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
