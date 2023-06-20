package boj;
import java.util.*;
import java.io.*;

public class BOJ_3040_백설공주와일곱난쟁이 {
	
	static int[] dwarf, visit, answer;
	static boolean flag;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarf = new int[9];
		answer = new int[7];
		flag = false;
		for(int i=0; i<9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		dfs(0,0,0);
		
	}
	static void dfs(int cnt, int level, int sum) {
		if(sum>100) return; // 모자의 합이 100이 넘어가면 리턴 
		if(flag) return;
		if(cnt==7) {
			if(sum==100) {
				for(int i : answer) {
					System.out.println(i);
				}
				flag = true;
			}
			return;
		}
		for(int i=level; i<9; i++) {
			answer[cnt] = dwarf[i];
			dfs(cnt+1, level+1, sum+dwarf[i]);
		}
		
	}

}
