import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, arr[], select[], visit[];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		select = new int[M];
		visit = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		dfs(0);
		System.out.println(sb.toString());
		
	}
	
	public static void dfs(int idx) {
		if(idx==M) {
			for(int s : select) {
				sb.append(s).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			if(visit[i]==1) continue;
			
			visit[i] = 1;
			select[idx] = arr[i];
			dfs(idx+1);
			visit[i] = 0;
		}
	}
}