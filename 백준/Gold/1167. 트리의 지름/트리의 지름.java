import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static ArrayList<Node> tree[];
    static boolean[] visited;
    static int answer = 0;
    static int temp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1)
                    break;
                int d = Integer.parseInt(st.nextToken());
                tree[s].add(new Node(e, d));
            }
        }
        // System.out.println(Arrays.deepToString(tree));
        dfs(1, 0);
        visited = new boolean[V + 1];
        dfs(temp, 0);
        System.out.println(answer);
    }

    public static void dfs(int v, int len) {
        if (len > answer) {
            answer = len;
            temp = v;
        }
        visited[v] = true;

        for (Node n : tree[v]) {
            if (!visited[n.v]) {
                visited[n.v] = true;
                dfs(n.v, len + n.d);
            }
        }
    }

    static class Node {
        int v;  // 연결된 정점 번호
        int d;  // 거리

        public Node(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }
}
