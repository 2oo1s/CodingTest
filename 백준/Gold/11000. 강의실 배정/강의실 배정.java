import java.io.*;
import java.util.*;

public class Main {

    static class Class implements Comparable<Class> {
        int start;
        int end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class c) {
            return this.start - c.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Class> list = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Class(s, e));
        }
        //  System.out.println(Arrays.deepToString(timetable));
        Collections.sort(list);

        int endTime = 0;
        for (Class c : list) {
            endTime = c.end;

            if (!q.isEmpty()) {
                if (q.peek() <= c.start)
                    q.poll();
            }
            q.add(endTime);
        }
        System.out.println(q.size());
    }
}