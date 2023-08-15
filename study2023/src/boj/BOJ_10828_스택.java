package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			case "pop":
				if(!stack.isEmpty()) {
					sb.append(stack.pop()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				int flag = stack.isEmpty() ? 1 : 0;
				sb.append(flag).append("\n");
				break;
			case "top":
				if(!stack.isEmpty()) {
					sb.append(stack.peek()).append("\n");
				}
				else {
					sb.append("-1").append("\n");
				}
				break;
			}
		}
		System.out.print(sb.toString());
	}
}
