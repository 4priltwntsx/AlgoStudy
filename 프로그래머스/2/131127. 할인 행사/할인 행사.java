import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0 ;i<want.length; i++){
            map.put(want[i], number[i]);
            count+= number[i];
        }


        for(int i=0 ;i<10; i++){
            if(map.containsKey(discount[i])){
                if(map.get(discount[i])>0) count--;
                map.put(discount[i], map.get(discount[i])-1);
            }
        }
        
        if(count==0) answer++;
        for(int i=0; i<discount.length-10; i++){
            if(map.containsKey(discount[i])){
                if(map.get(discount[i])>=0){
                    count++;
                }
                map.put(discount[i], map.get(discount[i])+1);
            }
            if(map.containsKey(discount[i+10])){
                if(map.get(discount[i+10])>0){
                    count--;
                }
                map.put(discount[i+10], map.get(discount[i+10])-1);
            }
            if(count==0) answer++;
        }
        
        // for(String key : map.keySet()){
        //     System.out.println(key + "??"+map.get(key));
        // }
        return answer;
    }
}