import java.io.*;
import java.util.*;
/*
크기 비교 진행
통분 유도하는 문제
왼손은 y 배수에 움직이고, 오른손은 x 배수에 움직이고
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());   // 왼손
        int y = Integer.parseInt(st.nextToken());   // 오른손

        for (int i = 1; i <= x * y; i++) {
            if (i % x == 0 && i % y == 0)
                System.out.print(3);
            else if (i % y == 0)
                System.out.print(1);
            else if (i % x == 0)
                System.out.print(2);
        }
    }
}