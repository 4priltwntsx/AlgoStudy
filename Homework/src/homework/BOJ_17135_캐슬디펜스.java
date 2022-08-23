package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
    static final int[] dx = {-1, -1, -1}; //up, right, down, left
    static final int[] dy = {-1,0,1};
	static int N, M, D;
	static int[][] map;
//	static ArrayList<Point> enemy;
	static HashSet<Point> enemy;
	static Point[] archers;
	static int enemyCounts;
	static int[] check;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //행
		M = Integer.parseInt(st.nextToken()); //열
		D = Integer.parseInt(st.nextToken()); //공격거리 제한
		
		map = new int[N+1][M];
		archers = new Point[3];
		check = new int[M];
		answer = Integer.MIN_VALUE;
		enemy = new HashSet<>();
		enemyCounts = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]== 1) {
					enemyCounts++;
				}

			}

			
		} //0은 빈칸, 1은 적
		
//		System.out.println(enemyCounts);
		
		ArcherComb(0,0);
		System.out.println(answer);
	}
	
	

	
	private static void ArcherComb(int cnt, int idx) {
		//M개의 열에 궁수 세명 배치 조합
		if(cnt == 3) {
			int result = attack(); //배치하고 공격하는데, 이 때 제거할 수 있는 적의 최대 수?,,,
			//게임이 끝날 때까지 이 조합으로 공격하고... 제거한 적의 최대수를 가져와서
			answer = Math.max(result, answer);
			return;
		}
		
		for(int i=idx; i<M; i++) {
			if(check[i]==0) {
				check[i] = 2; // 궁수 표시
				archers[cnt] = new Point(N, i);
				ArcherComb(cnt+1, i+1);
				check[i] = 0;
			}
			
		}
		
	}
	
	private static void BFS(Point archer, int[][] copy) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(archer.i, archer.j));
		int[][] check = new int[N][M];
		
		while(!Q.isEmpty()) {
			
			
			Point current = Q.poll();
			int x = current.i;
			int y = current.j;
			
			for(int d=0; d<3; d++) {
				for(int i=0; i<N; i++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					
					if(nx<0 || nx>=N || ny<0 || ny>=M) {
						continue;
					}
					if(check[nx][ny]==1)
						continue;
					
					if(copy[nx][ny] == 1) {
						int dis = distance(nx, ny, archer.i, archer.j);
						if(dis<=D) {
							enemy.add(new Point(nx,ny));
							return;
						}
					}

					Q.offer(new Point(nx, ny));
					check[nx][ny] = 1;
				}
				

				
			}
		}
		
	}
	
	
	private static int attack() {
		//공격 시 거리가 D이하인 적 중에서 가장 가까운 적, 여러명이면 가장 왼쪽 적 공격
		//공격 당한 enemy는 한 칸으로 이동하며 , N+1로 이동 시 게임에서 제외된다.
		int[][] copy = deepcopy(map);
		int result = 0;
		int ec = enemyCounts;
		
		Point first = archers[0];
		Point second = archers[1];
		Point third = archers[2];
		
		while(true) {
			if(ec<=0) break;
			print(copy);
			BFS(first, copy);
			BFS(second, copy);
			BFS(third, copy);
			
			for(Point temp : enemy) {
				if(copy[temp.i][temp.j]== 1) {
					copy[temp.i][temp.j] = 0; 
					result++;
					ec--;
				}
			}enemy = new HashSet<>();
			
			for(int j=0; j<M; j++) {
				for(int i=N-1; i>=0; i--){
					
					if(copy[i][j] == 1) { //적인데
						copy[i][j] = 0;
						if(i+1<N) {
							copy[i+1][j]=1;
						}else{
							ec--;
						}
					}
				}
			}
		}
		
		return result;
	}
	
	//격자판의 두 위치 거리 계산
	private static int distance(int r1, int c1, int r2, int c2) {
		int r = Math.abs(r1-r2);
		int c = Math.abs(c1-c2);
		
		return r+c;
	}
	
	static int[][] deepcopy(int[][] origin){
		int[][] copy = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		
		return copy;
	}
	
	static void print(int[][] arr) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j] +" ");
			}System.out.println();
		}System.out.println("******");
	}
	
	static class Point{
		int i, j;
		
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}