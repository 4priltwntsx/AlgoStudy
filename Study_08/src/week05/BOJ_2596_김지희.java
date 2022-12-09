package week05;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_2596_김지희 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		String letter = sc.next();
		
        HashMap<String, String> map = new HashMap<>();
        map.put("000000", "A");
        map.put("001111", "B");
        map.put("010011", "C");    
        map.put("011100", "D");
        map.put("100110", "E");
        map.put("101001", "F");
        map.put("110101", "G");
        map.put("111010", "H");
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++) {
        	
        	String str = letter.substring(6*i, 6*(i+1));
        	String result = map.get(str);
        	
        	if(result==null) {
        		//같은 게 없다
        		for(String key : map.keySet()) {
        			
        			char[] passwords = key.toCharArray();
        			char[] strs = str.toCharArray();
        			
        			int count =0;
        			for(int j=0; j<passwords.length; j++) {
        				
        				if(passwords[j] != strs[j]) 
        					count++; //숫자 한개는 알아볼 수 있으니까 한갠지 아닌지
        				if(count>=2) //2개이상이면 안됨
        					break;
        			}
        			
        			//숫자 한개는 알아볼 수 있음
        			if(count==1) {
        				result = map.get(key);
        				break;
        			}
        		}
        	}
        	
        	if(result!=null) {
        		//같은 것을 찾았다
        		sb.append(result);
        	}else {
        		System.out.println(i+1);
        		System.exit(0);
        	}
        }
        System.out.println(sb);
	}
}
