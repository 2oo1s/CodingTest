import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String answer = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);

			switch (temp) {
			case '+':
			case '-':
			case '*':
			case '/':
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(temp))
					answer += stack.pop();
				stack.add(temp);

				break;
			case '(':
				stack.add(temp);

				break;
			case ')':
				while (!stack.isEmpty() && stack.peek() != '(')
					answer += stack.pop();
				stack.pop(); // '(' 제거

				break;
			default:
				answer += temp;
			}
		}

		while (!stack.isEmpty())
			answer += stack.pop();

		System.out.println(answer);
	}

	public static int priority(char operator) {
		if (operator == '*' || operator == '/')
			return 2;
		else if (operator == '+' || operator == '-')
			return 1;
		else // '('와 ')'가 들어왔을 때
			return 0;
	}

}