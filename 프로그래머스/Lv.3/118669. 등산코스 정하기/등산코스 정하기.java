import java.util.*;

class Solution {
    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] isSummit;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        isSummit = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            dist[i] = Integer.MAX_VALUE;

        for (int i = 0; i < summits.length; i++)    // 산봉우리 번호 저장
            isSummit[summits[i]] = true;

        // 그래프 저장
        for (int[] path : paths) {
            int i = path[0];
            int j = path[1];
            int w = path[2];

            graph[i].add(new Node(j, w));
            graph[j].add(new Node(i, w));
        }

        for (int gate : gates) {
            dist[gate] = 0;
            pq.add(new Node(gate, 0));
        }

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currV = curr.vertex;
            int currT = curr.time;

            if (dist[currV] >= currT) {
                for (Node next : graph[currV]) {
                    if (dist[next.vertex] <= Math.max(currT, next.time))
                        continue;

                    dist[next.vertex] = Math.max(currT, next.time);

                    if (isSummit[next.vertex])
                        continue;

                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        int node = 0;
        int intensity = Integer.MAX_VALUE;

        for (int summit : summits) {
            if (dist[summit] < intensity) {
                intensity = dist[summit];
                node = summit;
            } else if (dist[summit] == intensity && summit < node) {
                intensity = dist[summit];
                node = summit;
            }
        }

        int[] answer = {node, intensity};

        return answer;
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int time;

        public Node(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }

        @Override
        public int compareTo(Node n) {
            return this.time - n.time;
        }
    }
}