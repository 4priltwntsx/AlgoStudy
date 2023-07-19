package boj;
import java.util.*;
import java.io.*;
public class BOJ_2961_도영이가만든맛있는음식 {
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] ingredients = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }
        
        answer = Integer.MAX_VALUE;
        
        dfs(1, 0, N, 0, ingredients);
        System.out.print(answer);
    }
    private static void dfs(int sour, int bitter, int n, int idx, int[][] ingredients){
        if(idx==n){
        	// 그 요리의 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수이다.
        	if(bitter==0) return; // size가 1이라 더해진게 없는 경우
            int sub = Math.abs(sour-bitter);
            if(sub<answer) answer = sub;
            return;
        }
        dfs(sour*ingredients[idx][0], bitter+ingredients[idx][1], n, idx+1, ingredients);
        dfs(sour, bitter, n, idx+1, ingredients);
    }
}
