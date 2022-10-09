import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2239_스도쿠 {
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static int[][] map;
	static ArrayList<Point> emptyList;
	static boolean isComplete;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		emptyList = new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			String line = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = line.charAt(j) - '0';
				if(map[i][j] == 0)
					emptyList.add(new Point(i, j));
			}
		}
		
		dfs(0);
	}
	
	
	private static void dfs(int idx) {
		if(idx==emptyList.size()) {
			
			
		}
	}
}
