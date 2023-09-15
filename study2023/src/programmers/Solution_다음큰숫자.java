package programmers;

public class Solution_다음큰숫자 {
	   static public int solution(int n) {
	        int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
	        return n + postPattern | smallPattern;
	    }
	
//    static public int solution(int n) {
//        int answer = 0;
//        int n_cnt = count_1(n);
//        int next = n+1;
//        while(true) {
//        	
//        	if(count_1(next)==n_cnt) {
//        		answer = next;
//        		break;
//        	}
//        	next++;
//        }
//        
//        return answer;
//    }
	
    static public int count_1(int num) {
    	int answer = 0;
    	while(num>0) {
    		if(num%2==1) {
    			answer++;
    		}
    		num/=2;
    	}
    	return answer;
    }
	
	public static void main(String[] args) {

		// 예제 1
		System.out.println(solution(78));
		
		// 예제 2
		System.out.println(solution(15));
	}
}
