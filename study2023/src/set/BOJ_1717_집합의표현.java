package set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(cmd==0) {
				union(a, b);
			}
			else if(cmd==1) {
				sb.append((isSame(a, b) ? "YES" : "NO")).append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}
	
	// x의 부모를 찾는 연산
	public static int find(int x) {
		if(x==parent[x]) {
			return x;
		}
		 return parent[x] = find(parent[x]);
	}
	
	// y의 부모를 x의 부모로 치환하는 연산
	public static void union(int x, int  y) {
		x = find(x); // 부모 찾기
		y = find(y);
		
		if(x!=y) {
			if(x<y) { // 낮은 값을 높은 값 아래에 넣는다.
				parent[y] = x;
			}else {
				parent[x] = y;
			}
		}
	}
	 
	// 부모가 같은지 확인
	public static boolean isSame(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) {
			return true;
		}
		return false;
	}
}
