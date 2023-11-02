import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        int len = number.length()-1;
        for(int i=0; i<number.length(); i++){
            char c = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < c && k-->0){
                stack.pop();
            }
            stack.push(c);
        }
        while(k-->0){
            stack.pop();
        }
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        StringBuffer sb = new StringBuffer(answer);
        answer = sb.reverse().toString();

        return answer;
    }
}