package bdfs;

import java.util.*;

public class Solution_42839_소수찾기 {
	static int[] select, answers;
    static boolean[] prime;
    static HashSet<Integer> permutations;
    public int solution(String numbers) {
        int answer = 0;
        prime = new boolean[10000001];
        prime[0] = prime[1] = true;
        sieve();
        select = new int[numbers.length()];
        
        permutations = new HashSet<>();
        for(int i=1; i<=numbers.length(); i++){
            select = new int[numbers.length()];
            answers = new int[i];
            perm(0, i, numbers);
        }
        for(int per : permutations){
            if(!prime[per]){
                answer++;
            }
            // System.out.println(per);
        }
        return answer;
    }
    
    public static void perm(int cnt, int N, String numbers){
       if(cnt==N){
           // 순열 완성
           String temp = "";
           for(int i : answers){
               temp += i;
           }
           // System.out.println(temp);
           permutations.add(Integer.parseInt(temp));
           return;
       }
        for(int i=0; i<numbers.length(); i++){
            if(select[i]==1) continue;
            answers[cnt] = numbers.charAt(i) - '0';
            select[i] = 1;
            perm(cnt+1, N, numbers);
            select[i] = 0;
        }
        
    }
    
    public static void sieve(){
        for(int i=2; i*i<=9999999; i++){
            if(!prime[i]){
                for(int j=i*i; j<=9999999; j+=i){
                    prime[j] = true;
                }
            }
        }
    }
}