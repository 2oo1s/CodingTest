import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N - 1];
        int[] cost = new int[N];
        int finalCost = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++)
            dist[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            cost[i] = Integer.parseInt(st.nextToken());

        int minCost = cost[0];
        for (int i = 1; i < N - 1; i++) {
            if (minCost > cost[i]) {
                finalCost += minCost * dist[i - 1];
                minCost = cost[i];
            } else {
                finalCost += minCost * dist[i - 1];
            }
        }
        finalCost += minCost * dist[N - 2];
        System.out.println(finalCost);
    }
}