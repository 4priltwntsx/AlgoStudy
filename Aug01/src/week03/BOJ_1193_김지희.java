package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193_김지희 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int line =0; // line 수
		int cnt =0; // line 마지막 수 
		int numerator = 0; //분자
		int denominator = 0; //분모
		
		while(cnt < N) {
			line++;
			cnt = line * (line + 1) /2; //등차수열의 합 이용
		}
		
		if(line%2!=0) {//뒤에서부터 홀수 라인은 분자증가 분모감소
			numerator = 1;
			denominator = line;
			while(cnt>N) {
				numerator++;
				denominator--;
				cnt--;
			}
		}else { //짝수라인은 분자증가 분모감소
			numerator = line;
			denominator = 1;
			while(cnt>N) {
				numerator--;
				denominator++;
				cnt--;
			}
		}
		
		System.out.println(numerator+"/"+denominator);
		
	}
}
