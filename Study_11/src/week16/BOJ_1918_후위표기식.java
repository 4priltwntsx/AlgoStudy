package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918_후위표기식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for(char ch : arr) {
			
			if(ch>='A' && ch<='Z') {
				sb.append(ch);
			}
			else { // 연산자일 떄,
//				if(stack.isEmpty()) { // 스택이 비어있으면 push
//					stack.push(ch);
//					continue;
//				}
				// 여기 아래로는 스택이 비어있지 않은 경우

				if(ch=='(') { // 제일 높은 우선 순위
					stack.push(ch);
				}
				else if(ch=='*' || ch=='/') {
					while(!stack.isEmpty() && (stack.peek()=='*'||stack.peek()=='/') ) {
						sb.append(stack.peek());
						stack.pop();
					}
					stack.push(ch);
				}
				else if(ch=='+' || ch=='-' || ch==')') {
					while(!stack.isEmpty() && stack.peek()!='(') {
						sb.append(stack.peek());
						stack.pop();
					}
					if(ch==')') {
						stack.pop(); // 여는 괄호 제거
					}
					else stack.push(ch);
				}
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.peek());
			stack.pop();
		}
		
		System.out.println(sb.toString());
	}
}
