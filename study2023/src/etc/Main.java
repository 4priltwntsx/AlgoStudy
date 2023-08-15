package etc;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] taebum = input.toCharArray();
        char[] yourim = br.readLine().toCharArray();
        char[] new_yourim = new char[4];
        int answer = 0;
        char[][] map = {{'E','I'},{'S','N'},{'F','T'},{'P','J'}};
        for(int i=0; i<4; i++){
            if(yourim[i]!= map[i][0] && yourim[i]!=map[i][1]){
                if(yourim[i]==map[0][0] || yourim[i]==map[0][1]){
                    new_yourim[0] = yourim[i];
                }else if(yourim[i]==map[1][0] || yourim[i]==map[1][1]){
                    new_yourim[1] = yourim[i];
                }else if(yourim[i]==map[2][0] || yourim[i]==map[2][1]){
                    new_yourim[2] = yourim[i];
                }else if(yourim[i]==map[3][0] || yourim[i]==map[3][1]){
                    new_yourim[3] = yourim[i];
                }
            }else{
                new_yourim[i] = yourim[i];
            }
    
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            answer =  taebum[i] != new_yourim[i] ? answer+1 : answer;
            sb.append(new_yourim[i]);
        }
        sb.append("\n").append(answer);
        System.out.print(sb.toString());
        long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기
        
     // 측정하려는 코드...
             
     long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
     long diffTime = afterTime - beforeTime; // 두 개의 실행 시간
     System.out.println("실행 시간(ms): " + diffTime); // 세컨드(초 단위 변환)
    }
}