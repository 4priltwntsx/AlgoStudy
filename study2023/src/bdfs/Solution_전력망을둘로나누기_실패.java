package bdfs;

import java.util.*;
class Solution_전력망을둘로나누기_실패 {
    static ArrayList<Integer>[] graph;
    static int N, visit[];
    static ArrayList<Integer> Aset, Bset;
    static int answer;
    public int solution(int n, int[][] wires) {
        answer = -1;
        N = n;
        graph = new ArrayList[n+1];
        visit = new int[N+1];
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        answer = Integer.MAX_VALUE;
        
        for(int i=N/2; i>=1; i--){
            comb(i, 1);
        }
        
        return answer;
    }
    
    private static void comb(int cnt, int idx){
        if(cnt==0){
            Aset = new ArrayList<>();
            Bset = new ArrayList<>();
            
            for(int i=1; i<=N; i++){
                if(visit[i]==1){
                    Aset.add(i);
                }else{
                    Bset.add(i);
                }
            }
            if(Aset.size()==0 || Bset.size()==0) return;
            
            // 연결 확인
            if(!isConnected(Aset)) return;
            if(!isConnected(Bset)) return;
            
            // 연결 되어 있으면
            int temp = Math.abs(Aset.size()-Bset.size());

            if(answer>temp){
                answer = temp;
            }
           return;
        }
        
        for(int i=idx; i<=N; i++){
            visit[i] = 1;
            comb(cnt - 1, i+1);
            visit[i] = 0;
        }


    }
    
    public static boolean isConnected(ArrayList<Integer> list){
        int start = list.get(0);
        int[] visited = new int[N+1];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        visited[start] = 1;
        
        while(!Q.isEmpty()){
            int cur = Q.poll();
            
            for(int next : graph[cur]){
                if(list.contains(next)){
                    if(visited[next]==0){
                        visited[next] = 1;
                        Q.add(next);
                    }
                }
            }
        }
        
        for(int i : list){
            if(visited[i]==0) return false;
        }
        return true;
    }
}