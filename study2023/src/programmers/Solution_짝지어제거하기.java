package programmers;

import java.util.Stack;

public class Solution_짝지어제거하기 {
	public int solution(String s) {
		int answer = -1;
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (stack.isEmpty())
				stack.push(s.charAt(i));
			else if (stack.peek() != s.charAt(i))
				stack.push(s.charAt(i));
			else
				stack.pop();

		}
		answer = stack.isEmpty() ? 1 : 0;

		return answer;
	}
}
