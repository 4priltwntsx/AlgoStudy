package programmers;

import java.io.IOException;

public class PRGRMS_150368_이모티콘할인행사 {
    static int[] rates = {10, 20, 30, 40};
    static int[] selected;
    
    static int max_subscribe;
    static int max_cost;
    public static void main(String[] args) throws IOException{
    	
    }
     
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int emoticons_length = emoticons.length;
        selected = new int[emoticons_length];
        max_subscribe = 0;
        max_cost = 0;
        
        perm(0, emoticons_length, users, emoticons);
        answer[0] = max_subscribe;
        answer[1] = max_cost;
        
        return answer;
    }
    
    public void perm(int idx, int emoticons_length, int[][] users, int[] emoticons){
        if(idx == emoticons_length){ // 할인률 중복순열을 다 구했으면,
            int subscribe = 0;
            int cost = 0;
            
            for(int[] user : users){
                int u_rate = user[0];
                int u_cost = user[1];
                int sum = 0;
                
                for(int i=0; i<emoticons_length; i++){
                    if(u_rate<=selected[i]){ // user기준보다 할인율이 같거나 높아야 구매.
                        sum += emoticons[i] * (100-selected[i])/100;
                    }
                }  
                if(sum>=u_cost) subscribe++;
                else cost+=sum;
            }
            // 모든 유저를 다 돌았다.
            // 최대 가입자수(1순위)와 매출액 (2순위)계산
            if(subscribe>max_subscribe){
                max_subscribe = subscribe;
                max_cost = cost;
            }else if(subscribe==max_subscribe){
                if(cost>max_cost) max_cost = cost;
            }                
            return;
        }
        
        for(int i=0; i<4; i++){
            selected[idx] = rates[i];
            perm(idx+1, emoticons_length, users, emoticons);
        }
    }
}
