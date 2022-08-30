import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Solution_낚시터자리잡기 {

	static int N; //낚시터 자리의 개수
	static int[] arr; //낚시터
	static HashMap<Integer, Integer> map;
	static int[] gateNums;
	static int[] visit;
	static int[] select;
	static int fisherCnt;
	static int answer;
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			System.out.print("#"+tc+" ");
			
			N = sc.nextInt(); // 낚시터의 자리 개수
			arr = new int[N+1];
			map = new HashMap<>();
			gateNums = new int[3];
			visit = new int[3];
			select = new int[3];
			
			for(int i=0; i<3; i++) {
				int gate = sc.nextInt();
				int cnt = sc.nextInt();
				map.put(gate, cnt);
				gateNums[i] = gate;
				
			}
			answer= Integer.MAX_VALUE;
			perm(0);
			System.out.println(answer);
		}
	}
	
	private static void perm(int cnt) {
		if(cnt==3) {
//			arr = new int[N+1];
			dfs(0, 0);
			
			return;
		}
		for(int i=0; i<3; i++) {
			if(visit[i] == 0) {
				visit[i] = 1;
				select[cnt] = gateNums[i];
				perm(cnt+1);
				visit[i] = 0;
			}
		}
	}
	
	private static void dfs(int cnt, int sum) {
		if(sum>=answer) return;
		if(cnt==3) {
			answer = Math.min(answer, sum);
			return;
		}
		
		dfs(cnt+1, sum + enter(select[cnt], true));
		recovery(select[cnt]);
		if(select[cnt]%2 == 0) {
			dfs(cnt+1, sum + enter(select[cnt], false));
			recovery(select[cnt]);
		}

//		recovery(select[cnt]);
	}
	
	private static int enter(int gateNum, boolean direction) {
		int distance = 0;
		int sum =0;
		fisherCnt = map.get(gateNum);
		
		
		while(fisherCnt>0){
			sum+= direction ? left(gateNum, distance) : right(gateNum, distance);
			
			if(fisherCnt == 0) break;
			
			sum+= direction ? right(gateNum, distance) : left(gateNum, distance);
			
			distance++;
		}
		
		
		return sum;
	}
	
	private static int left(int gateIdx, int distance) {
		int res = gateIdx - distance; //gate부터 떨어진 거리
//		System.out.println(res);
		
		if(res>0 && arr[res] == 0) {
			arr[res] = gateIdx; //어디서 들어온 사람인지 체크하려고
			fisherCnt--;
			return distance+1;
		}
		//이동할 수 없었으면 0 리턴
		return 0;
	}
	
	private static int right(int gateIdx, int distance) {
		int res = gateIdx + distance; //gate부터 떨어진 거리
		
		if(res<=N && arr[res] == 0) {
			arr[res] = gateIdx; //어디서 들어온 사람인지 체크하려고
			fisherCnt--;
			return distance+1;
		}
		//이동할 수 없었으면 0 리턴
		return 0;
	}
	
	private static void recovery(int idx) {
		for(int i=0; i<=N; i++) {
			if(arr[i] == idx) {
				arr[i] = 0;
			}
		}
	}
}
