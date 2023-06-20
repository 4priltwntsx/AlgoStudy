import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_안정된집단 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		// 모르겠는디
		
	}
}
