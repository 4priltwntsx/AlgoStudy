import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Softeer_로봇이지나간경로 {
	
	static int H, W;
	static char[][] map;
	static char[] dc = {'>','<','v','^'};
	// 동 서 남 북
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static int answer = 0;
	
	static class Direct{
		int a,b;
		Direct(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	
	static int[][] dsnb = {{0,1},{0,3},{0,2},{1,0},{1,3},{1,2},{2,1},{2,0},{2,3},{3,1},{3,2},{3,0}};
	static String[] act = {"LL","L","R","RR","R","L","R","L","LL","L","LL","R"};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int count = 0;

		int fi = 0, fj = 0;

		map = new char[H][W];
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
			if (count == 0) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '#' && count == 0) {
						fi = i;
						fj = j;
						count++;
					}
				}
			}
		}
		
		dfs(fi, fj, 0);
		
	}
	
	
	private static void dfs(int ni, int nj, int nd) {
		
		
		
	}
	
}
