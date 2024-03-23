import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        list = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        dfs(0, 0);
    }

    public static void dfs(int cnt, int s) {
        if (cnt == m) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
            return;
        }

        for (int i = s; i < n; i++) {
            list[cnt] = arr[i];
            dfs(cnt + 1, i + 1);
        }
    }
}