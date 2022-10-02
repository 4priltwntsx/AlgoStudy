import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	
	static int[] voucher;
	
	static int[] plan;
	
//	static boolean yearValiable;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			voucher = new int[4];
			plan = new int[13];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<4; i++) {
				voucher[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			//input end
			
//			yearValiable = true;
			answer = Integer.MAX_VALUE;
			dfs(1, 0);
			System.out.println("#"+tc+" " + answer);
			
		}
	}
	private static void dfs(int cnt, int price) {
		if(price>=answer) return;
		
		if(cnt>12) {
			answer = Math.min(answer, price);
			return;
		}
		if(plan[cnt]!=0) { //계획이 있으면?
			for(int i=0; i<4; i++) {
				if(i==0) {
					dfs(cnt+1, price+voucher[i]*plan[cnt]);
				}
				else if(i==1) { //한달 이용권
					dfs(cnt+1, price+voucher[i]);
				}else if(i==2) { //3개월 이용권
					dfs(cnt+3, price+voucher[i]);
				}else if(i==3) { //1년 이용권
					dfs(cnt+12, price+voucher[i]);
				}
			}
		}else if(plan[cnt]==0) {
			dfs(cnt+1, price);
		}
		
	}
}
