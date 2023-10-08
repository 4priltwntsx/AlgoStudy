package bdfs;

import java.util.ArrayList;

public class Solution_모음사전 {
    static ArrayList<String> list;
    static char[] aeiou = {'A', 'E', 'I', 'O', 'U'};
    static boolean flag;
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        flag = false;
        
        dfs(0, "", word);
        answer = list.size();
        return answer;
    }
    
    public static void dfs(int cnt, String str, String word){
        if(flag) return;
        if(str.equals(word)) {
            flag = true;
            return;
        }
        list.add(str);
        
        if(cnt==5) return;
        
        
        for(int i=0; i<5; i++){
            dfs(cnt+1, str+aeiou[i], word);
        }
    }
}
