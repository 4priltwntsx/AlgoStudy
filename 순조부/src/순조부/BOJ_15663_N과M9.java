package 순조부;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class BOJ_15663_N과M9 {
	static int N, M;
	static int[] arr, select, visit;
	static LinkedHashSet<String> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		select = new int[M];
		visit = new int[N];
		int max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			if(max<arr[i]) max = arr[i];
		}
		set = new LinkedHashSet<>();
		Arrays.sort(arr);
		dfs(0);
		for(String str: set) {
			System.out.print(str);
		}
	}
	
	private static void dfs(int cnt) {
		if(cnt==M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(select[i]).append(" ");
			}sb.append("\n");
			set.add(sb.toString());
			return;
		}
		for(int i=0; i<N; i++) {
			if(visit[i]==1) continue;
			visit[i] = 1;
			select[cnt] = arr[i];
			dfs(cnt+1);
			visit[i] = 0;
		}
	}
}
