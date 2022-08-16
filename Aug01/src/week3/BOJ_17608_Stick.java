package week3;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_17608_Stick {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int first = sc.nextInt();
		stack.push(first);
		
		for(int i=1; i<N; i++) {
			
			int temp = sc.nextInt();
			int top = stack.peek();
			if(top<=temp) {
				while(stack.peek()<=temp) {
					stack.pop();
					if(stack.size()==0) break;
				}
//				stack.pop();
				stack.push(temp);
			}
			else {
				stack.push(temp);
			}
		}
		
		System.out.println(stack.size());
	}
}
