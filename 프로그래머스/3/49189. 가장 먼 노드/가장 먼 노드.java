import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int arr[];
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    
    public int solution(int n, int[][] edge) { 
        int answer = 0;
        graph = new ArrayList[n + 1];
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        
        for(int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]); 
            graph[edge[i][1]].add(edge[i][0]);  
        }
        
       // System.out.println(Arrays.deepToString(graph));
        
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()) {
            int tmp = q.poll();
            for(int i : graph[tmp]) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    arr[i] = arr[tmp] + 1;
                }
            }
        }
        Arrays.sort(arr);
        int cnt = 0;
        int max = arr[n];
        
        for(int i = 0; i <= n; i++) {
            if(max == arr[i]) 
                cnt++;   
        }
        return cnt;
    }
}