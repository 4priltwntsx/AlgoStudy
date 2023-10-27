import java.util.*;

class Solution {
    TreeMap<Integer, Integer> map;
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        map = new TreeMap<>();
        
        for(int tang : tangerine){
            map.put(tang, map.getOrDefault(tang, 0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>(){
           public int compare(Integer o1, Integer o2){
               return map.get(o2) - map.get(o1);
           } 
        });
        
        for(Integer i : list){
            if(k<=0) break;
            k -= map.get(i);
            answer++;
        }
        return answer;
    }
}