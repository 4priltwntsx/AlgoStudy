package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨테이어벨트위의로봇 {
	static int[][] belt;
	static int N, K, capaCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N + 1][2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 2 * N; i++) {
			belt[i][1] = Integer.parseInt(st.nextToken());
		}
		int turn = 0;
		while(true) {
			turn++;
			if(move()) {
				System.out.println(turn);
				break;
			}
		}

	}

	public static boolean move() {

		// 1번 수행
		int temp = belt[2 * N][1]; // 맨 마지막 칸 내구성
		for (int i = 2 * N; i > 1; i--) {
			if (i >= N) {
				belt[i][0] = 0;
				belt[i][1] = belt[i-1][1];
			}
			else {
				belt[i][1] = belt[i - 1][1]; // 내구성 이동
				belt[i][0] = belt[i - 1][0]; // 로봇도 이동
			}
		}
		belt[1][1] = temp; // 첫칸 내구성
		belt[1][0] = 0;

		// 2번 수행. 로봇 이동
		for (int i = N; i > 1; i--) {
			if(belt[i][0]==0 && belt[i][1]>0 && belt[i-1][0]!=0) {
				belt[i][0] = belt[i-1][0];
				belt[i-1][0] = 0;
				belt[i][1]--;
			}
		}
		
		// 3번 수행
		if(belt[1][1]>0) {
			belt[1][0] = 1;
			belt[1][1]--;
		}
		
		// 4번 수행
		capaCnt = 0;
		for(int i=1; i<=2*N; i++) {
			if(belt[i][1] == 0) {
				capaCnt++;
			}
			if(capaCnt==K) {
				return true;
			}
		}
		
		return false;
	}
}
