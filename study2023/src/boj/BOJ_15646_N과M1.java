package boj;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15646_N과M1 {
	
	static int[] check, answer;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//수열은 중복되면 안되고, 공백으로 구분해서 출력
		answer = new int[M];
		check = new int[N+1];
		perm(N, M, 0);
	}
	
	private static void perm(int N, int M, int cnt) {
		if(cnt==M) {
			for(int j =0 ; j<cnt; j++) {
				System.out.print(answer[j] + " ");
			}System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(check[i]==1) continue;
			
			check[i] = 1;
			answer[cnt] = i;
			perm(N, M, cnt+1);
			check[i] = 0;
		}
	}
}
