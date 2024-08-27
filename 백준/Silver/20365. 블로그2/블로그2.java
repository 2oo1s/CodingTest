import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] array = str.toCharArray();

        int b = 0, r = 0;
        char prev = ' ';

        for (char c : array) {
            if (c != prev) {
                if (c == 'B')
                    b++;
                else
                    r++;
            }
            prev = c;
        }
        System.out.println(Math.min(b, r) + 1);
    }
}