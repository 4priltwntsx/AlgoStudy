package programmers;
import java.util.*;

public class PRGRMS_120808_분수의덧셈 {
    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int ansDenom = denom1*denom2;
        numer1 = numer1 * denom2;
        numer2 = numer2 * denom1;
        int ansNumer = numer1 + numer2;
        int min = gcd(ansNumer, ansDenom);
        answer[0] = ansNumer/min;
        answer[1] = ansDenom/min;
        return answer;
    } 
    private static int gcd(int a, int b){ 
        if(b == 0) return a; 
        return gcd(b, a % b); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = solution(1,2,3,4);
		System.out.print(answer[0] + " "+answer[1]);
	}
}
