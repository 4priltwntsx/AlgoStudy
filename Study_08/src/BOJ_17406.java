import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
	static int N,M,K;
	static int[][] map;
	static int[][] recover;
	static int min = Integer.MAX_VALUE;
	static int[][] rot;
	static int[] idxArr;
	static boolean[] check;
	
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };


			
	static void rotation(int r, int c, int num) {
		r--;
		c--;
		
		for (int i = 0; i < num; i++) {
			int tmp = map[r - num + i][c - num + i];

			int ly = r - num + i;
			int lx = c - num + i;
			int edgeCnt = 0;
			while (edgeCnt < 4) {
				int ny = ly + dy[edgeCnt];
				int nx = lx + dx[edgeCnt];

				if (ny >= r - num + i && nx >= c - num + i && ny <= r + num - i && nx <= c + num - i) {
					map[ly][lx] = map[ny][nx];
					ly = ny;
					lx = nx;
				} else {
					edgeCnt++;
				}
			}
			map[r - num + i][c - num + i + 1] = tmp;
		}
		print();

	}
	
	public static void calculator() {
		for(int i=0; i<N; i++) {
			int sum=0;
			for(int j=0; j<M; j++) {
				sum+=map[i][j];
			}
			min = Math.min(min, sum);
		}
	}
	
	public static void perm(int L) {

		if(L == K) {
			int r,c,s;
			
			for(int i=0; i<L;i++) {
				int idx = idxArr[i];
				r = rot[idx][0];
				c = rot[idx][1];
				s = rot[idx][2];
//				System.out.println(r+ " "+c+" "+s);
				rotation(r,c,s);
			}

			calculator();
			recovery();
			return;
		}
		
		else {
			for(int i=0; i<K; i++) {
				if(check[i]==false) {
					check[i] = true;
					idxArr[L] = i; 
					perm(L+1);
					check[i]=false;
				}
			}
		}

	} 
	
	public static void recovery() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = recover[i][j];
			}
		}
	}
	
	public static void print() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}System.out.println();
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		recover = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				recover[i][j] = map[i][j];
			}
		}

		
		rot = new int[K][3];
		check = new boolean[K];
		idxArr = new int[K];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				rot[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
//		rotation(3,4,2);
		
//		print();
		System.out.println(min);
		
		
		
	}
}