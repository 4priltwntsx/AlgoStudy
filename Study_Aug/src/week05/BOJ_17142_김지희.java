package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//연구소3
public class BOJ_17142_김지희 {
	
    static class Virus {
        int x, y, time;

        Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
 
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Virus> viruses = new ArrayList<>();
    static Virus[] active;
    static int result = Integer.MAX_VALUE;
    static int empty = 0;

    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];
        active = new Virus[M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 0) {
                    empty++;
                } else if (arr[i][j] == 2) {
                    viruses.add(new Virus(i, j, 0));
                }
            }
        }
        
        if(empty==0) {
        	System.out.println(0);
        }else {
        	comb(0,0);
        	if(result == Integer.MAX_VALUE) System.out.println(-1);
        	else System.out.println(result);
        }
	}
    
    
    private static void comb(int idx, int cnt) {
    	if(cnt == M) {
    		//고른 M개의 바이러스로 바이러스 퍼트리기
    		bfs(empty);
    		return;
    	}
    	for(int i=idx; i<viruses.size(); i++) {
    		active[cnt] = viruses.get(i);
    		comb(i+1, cnt+1);
    	}
    }
    
    private static void bfs(int empty) {
    	Queue<Virus> Q = new LinkedList<>();
    	int[][] visit = new int[N][N];
    	
    	for(int i=0; i<M; i++) {
    		Virus v = active[i];
    		visit[v.x][v.y] = 1;
    		Q.add(v);
    	}
    	
    	while(!Q.isEmpty()) {
    		Virus cur = Q.poll();
    		
    		for(int i=0; i<4; i++) {
    			int nx = cur.x + dx[i];
    			int ny = cur.y + dy[i];
    			
    			if(nx>=0 && nx<N && ny>=0 && ny<N
    					&& visit[nx][ny] == 0 && arr[nx][ny] != 1) {
    				
    				if(arr[nx][ny] == 0) 
    					empty--;
    				
					if(empty == 0) {
						result = Math.min(result, cur.time+1);
						return;
					}
					visit[nx][ny] =1;
					Q.add(new Virus(nx, ny, cur.time+1));
    			}
    		}
    	}
    }
    
}