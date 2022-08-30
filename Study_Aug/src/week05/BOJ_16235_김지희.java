package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16235_김지희 {
	
	static class Tree implements Comparable<Tree>{
		int x, y, age;
		Tree(int x, int y, int age){
			this.x = x;
			this.y = y;
			this.age =age;
		}
		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return this.age-o.age;
		}
	}
	static int[] dx =  { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	
	
	static int N, M, K;  // NxN, M개의 나무묘목, K년 후 살아남은 나무 수
	static int[][] nutrients; //초기 양분
	static int[][] A;// 추가되는 양분
	static PriorityQueue<Tree> trees;
	static ArrayList<Tree> deadTrees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nutrients = new int[N+1][N+1];
		A = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				nutrients[i][j] = 5; //초기 양분
				A[i][j] = Integer.parseInt(st.nextToken()); //추가 양분
			}
		}
		
		trees = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			trees.add(new Tree(x, y, age));
		}
		//input end
		
		
		while(K>0) {
			//죽은 나무 리스트
			deadTrees = new ArrayList<>();
			
			trees = spring();
			summer();
			trees = fall();
			winter();
			
			K--;
			
		}
		
		int answer = trees.size();
		System.out.println(answer);
	}
	
	private static PriorityQueue<Tree> spring() {
		PriorityQueue<Tree> tmpQ = new PriorityQueue<>();
		
		while(!trees.isEmpty()){
			Tree tree = trees.poll();
			int x = tree.x;
			int y = tree.y;
			int age= tree.age;
			if(age>nutrients[x][y]) {
				//양분을 먹지 못하는 경우 죽는다.
				deadTrees.add(new Tree(x, y, age/2)); //나중에 여름에 나이/2만큼의 양분이 되므로
				continue;
			}
			//양분을 먹을 수 있는 경우
			nutrients[x][y] -= age; //나이만큼 먹고 남은 거 다시 넣어주고

			tmpQ.offer(new Tree(x, y, age+1));
		}
		return tmpQ;
	}
	
	private static void summer() {
		int size = deadTrees.size();
		for(int s=0; s<size; s++) {
			Tree tree = deadTrees.get(s);
			int x = tree.x;
			int y = tree.y;
			int nut = tree.age;
			nutrients[x][y] += nut;
		}
	}
	
	private static PriorityQueue<Tree> fall() {
		PriorityQueue<Tree> tmpQ = new PriorityQueue<>();
		
		while(!trees.isEmpty()){
			Tree tree = trees.poll();
			
			tmpQ.add(tree);
			if(tree.age%5==0){
				int x= tree.x;
				int y = tree.y;
				int age = tree.age;
				
				for(int d=0; d<8; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					
					if(nx>0 && ny>0 && nx<=N && ny<=N) {
						tmpQ.add(new Tree(nx, ny, 1));
					}
				}
			}
		}
		return tmpQ;
	}
	
	private static void winter() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				nutrients[i][j] += A[i][j];
			}
		}
	}
}