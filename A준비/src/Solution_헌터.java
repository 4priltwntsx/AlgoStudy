import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_헌터 {
	static class Point{
		int x, y;
		int num;
		Point(int x, int y, int num){
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	
	static int N;
	static ArrayList<Point> monsters;
	static ArrayList<Point> customers;
	static boolean[] visitMonsters;
	static boolean[] visitCustomers;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			monsters = new ArrayList<>();
			customers = new ArrayList<>();
			
			N = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n<0) {
						n*=(-1);
						//customer
						customers.add(new Point(i, j, n));
					}
					else if(n>0) {
						monsters.add(new Point(i, j, n));
					}
				}
				visitMonsters = new boolean[N];
				visitCustomers = new boolean[N];
			}
			
			DFS(0, 0, 0, 0);
			
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	private static void DFS(int cnt, int distance, int r, int c) {
		if(distance >= answer) return;
		if(cnt == monsters.size()*2) {
			answer = Math.min(answer, distance);
		}
		
		for(Point monster : monsters) {
			if(visitMonsters[monster.num]) continue;
			
			int d = getDistance(monster.x, monster.y, r, c);
			visitMonsters[monster.num] = true;
			DFS(cnt+1, distance+d, monster.x, monster.y);
			visitMonsters[monster.num] = false; 
		}
		
		for(Point customer : customers) {
			int n = Math.abs(customer.num);
			if(visitCustomers[n] || !visitMonsters[n]) continue;
			
			int d = getDistance(customer.x, customer.y, r, c);
			visitCustomers[n] = true;
			DFS(cnt+1, distance+d, customer.x, customer.y);
			visitCustomers[n] = false;
		}
	}
	
	private static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
}
