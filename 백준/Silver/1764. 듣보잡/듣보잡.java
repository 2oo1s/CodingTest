import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] notHeard = new String[n];
        String[] notSeen = new String[m];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            notHeard[i] = br.readLine();
            map.put(notHeard[i], 1);
        }
        // System.out.println(map);

        for (int i = 0; i < m; i++) {
            notSeen[i] = br.readLine();
            map.put(notSeen[i], map.getOrDefault(notSeen[i], 0) + 1);
        }
        // System.out.println(map);

        List<String> nameSet = new ArrayList<>(map.keySet());
        Collections.sort(nameSet);

        int cnt = (n + m) - map.size();
        sb.append(cnt).append("\n");

        for (String s : nameSet) {
            if (map.get(s) > 1)
                sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }
}