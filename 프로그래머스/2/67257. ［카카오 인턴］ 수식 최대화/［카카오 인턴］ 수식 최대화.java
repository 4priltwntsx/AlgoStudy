import java.util.*;
class Solution {
    static ArrayList<Long> numList;
    static ArrayList<Character> operList;
    static int visit[];
    static char[] operation = {'-', '+', '*'};
    static char[] operSelect;
    static long answer;
    
    public long solution(String expression) {
        answer = 0;
        String number = "";
        numList = new ArrayList<>();
        operList = new ArrayList<>();
        
        for(int i=0; i<expression.length(); i++){
            char now = expression.charAt(i);
            if(now=='-' || now=='+' || now=='*'){
                operList.add(now);
                numList.add(Long.parseLong(number));
                number = "";
            }else{
                number+=now;
            }
        } // 분리
        numList.add(Long.parseLong(number));
        
        // 연산자 우선순위와 연산
        operSelect = new char[3];
        visit = new int[3];
        dfs(0);
        
        return answer;
    }
    
    public static void dfs(int cnt){
        if(cnt == 3){
            long temp = solve();
            if(answer<temp) answer = temp;
            return;
        }
        
        for(int i=0; i<3; i++){
            if(visit[i]==1) continue;
            operSelect[cnt] = operation[i];
            visit[i] = 1;
            dfs(cnt+1);
            visit[i] = 0;
        }
    }
    
    public static long solve(){
        long result = 0;
        ArrayList<Character> oper = new ArrayList<>(operList);
        ArrayList<Long> num = new ArrayList<>(numList);
        
        for(int i=0; i<3; i++){
            char nowOper = operSelect[i];
            
            for(int idx = 0; idx<oper.size(); idx++){
                if(oper.get(idx)==nowOper){
                    long a = num.get(idx);
                    long b = num.get(idx+1);
                    result = calc(a, b, nowOper);
                    
                    num.remove(idx+1);
                    num.set(idx, result);
                    oper.remove(idx);
                    
                    idx--;
                }
            }
        }
        return Math.abs(result);
    }
    
    public static long calc(long a, long b, char c){
        switch(c){
            case '-':
                return a-b;
            case '+':
                return a+b;
            default:
                return a*b;
        }
    }
}