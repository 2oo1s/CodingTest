import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] height = new int[w];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < w; i++)
            height[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < w - 1; i++) {
            int leftHeight = 0;
            int rightHeight = 0;

            for (int j = 0; j < i; j++)
                leftHeight = Math.max(height[j], leftHeight);
            for (int j = i + 1; j < w; j++)
                rightHeight = Math.max(height[j], rightHeight);

            if (height[i] < leftHeight && height[i] < rightHeight)
                answer += Math.min(leftHeight, rightHeight) - height[i];
        }

        System.out.println(answer);
    }
}