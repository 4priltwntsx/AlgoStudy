package programmers;

import java.util.ArrayList;

public class Solution_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int turn = 0, idx=0;
        ArrayList<String> list = new ArrayList<>();
        String pre = "";
        
        for(int i=0; i<n; i++){
            int widx = n * turn + i;
            if(widx==0){
                list.add(words[0]);
                pre = words[0];
                continue;
            }
            if(widx>=words.length) break;
            if(!list.contains(words[widx]) 
               && pre.charAt(pre.length()-1) == words[widx].charAt(0)){
                list.add(words[widx]);
                pre = words[widx];
            }else{
                answer[0] = i+1;
                answer[1] = turn+1;
                break;
            }
            if(i==n-1) {
                i = -1;
                turn++;
            }
        }
    

        return answer;
    }
}
