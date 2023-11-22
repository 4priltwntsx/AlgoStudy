import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, eggs[][], answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		System.out.println(answer);
		
		
	}
	
	public static void dfs(int cnt, int idx) {
		if(cnt==N-1 || idx==N) {
			answer = Math.max(answer, cnt);
			return;
		}
		
		if(eggs[idx][0]<=0) { // 현재 손에 든 계란이 깨져있음 안 치고 넘어감.
			dfs(cnt, idx+1); // 다음 계란 (한칸 오른쪽)
		}else { // 안깨져있음
			for(int i=0; i<N; i++) {
				if(i==idx) continue; // 오른손 계란은 랜덤임
				if(eggs[i][0]<=0) continue;
				eggs[idx][0] -= eggs[i][1];
				eggs[i][0] -= eggs[idx][1];
				int temp=0;
				if(eggs[idx][0]<=0) temp++;
				if(eggs[i][0]<=0) temp++;
				dfs(cnt+temp, idx+1);
				eggs[idx][0] += eggs[i][1];
				eggs[i][0] += eggs[idx][1];
			}
		}
	}
}