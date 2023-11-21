import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0){
            return cities.length * 5;
        }
        LinkedList<String> list = new LinkedList<>();
        for(String city : cities){
            String now = city.toUpperCase();
            if(list.remove(now)){
                list.add(now);
                answer+=1;
            }
            else{
                if(list.size()>=cacheSize){
                    list.remove(0);
                    list.add(now);
                    answer+=5;
                }
                else{
                    list.add(now);
                    answer+=5;
                }
            }
        }
        return answer;
    }
}