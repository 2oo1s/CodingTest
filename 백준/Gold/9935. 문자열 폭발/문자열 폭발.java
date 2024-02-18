import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= target.length()) {
                boolean flag = true;
                
                for (int j = 0; j < target.length(); j++) {
                    if (stack.get(stack.size() - target.length() + j) != target.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < target.length(); j++)
                        stack.pop();
                }
            }
        }

        for (Character c : stack)
            answer.append(c);


        if (answer.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(answer);
    }
}