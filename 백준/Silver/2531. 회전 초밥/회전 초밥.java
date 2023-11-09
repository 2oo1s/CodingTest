import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] dish = new int[N + k - 1];
        for (int i = 0; i < N; i++)
            dish[i] = Integer.parseInt(br.readLine());


        for (int i = N; i < N + k - 1; i++)
            dish[i] = dish[i - N];

        int[] eat = new int[d + 1];
        int cnt = 1; // 쿠폰 접시는 먹었다고 가정
        eat[c]++;

        int s = 0;
        int e = k;  // 윈도우 초기 설정
        for (int i = s; i < k; i++) {
            if (eat[dish[i]] == 0)
                cnt++;
            eat[dish[i]]++;
        }

        int temp = cnt;
        for (int i = e; i < dish.length; i++) {
            eat[dish[s]]--;
            if (eat[dish[s]] == 0)
                temp--;
            if (eat[dish[i]] == 0)  // 슬라이드를 오른쪽으로 한 칸 밀었을 때, 추가되는 초밥 처리
                temp++;
            eat[dish[i]]++;
            cnt = Math.max(cnt, temp);
            s++;
        }
        System.out.println(cnt);
    }
}