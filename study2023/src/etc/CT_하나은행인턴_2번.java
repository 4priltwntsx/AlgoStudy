package etc;

import java.util.*;

public class CT_하나은행인턴_2번 {

	public static void main(String[] args) {
		int[][] map = { { 1, 1, 2, 1, 3, 7 }, { 4, 1, 0, 0, 0, 2 }, { 1, 13, 3, 8, 4, 3 }, { 4, 3, 2, 1, 5, 4 },
				{ 1, 6, 1, 1, 1, 1 } };
		int[] cage = { 3, 3 };
		// test case 1 : result = [37, 6]
	}

	public static int[] solution(int[][] map, int[] cage) {
		int[] answer = new int[2];
		int[] di = { 1, -1, 0, 0 };
		int[] dj = { 0, 0, 1, -1 };
		
		int N = map.length;
		int M = map[0].length;
		int visit[][] = new int[N][M];
		Point start = new Point(cage[0]-1, cage[1]-1);
		
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				Point cur = q.poll();
				
				if(cur.i==0 || cur.i==N-1 || cur.j==0 || cur.j==M-1) {
					// 현재 좌표까지가 최대 범위
					
				}
				for(int d=0; d<4; d++) {
					int ni = cur.i + di[d];
					int nj = cur.j + dj[d];
					
					if(ni<0 || nj<0 || ni>=N || nj>=M || visit[ni][nj]!=0 || map[ni][nj]==0) continue;
					
					
				}
			}
		}
		
		

		return answer;
	}

	public static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	// 모르겠음...
}
