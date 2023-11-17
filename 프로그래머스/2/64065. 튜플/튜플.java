import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        s = s.replace("},{", "-");
        String[] arr = s.split("-");
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                return a.length()-b.length();
            }
        }); // 정렬
        ArrayList<String> list = new ArrayList<>();
        for(String a : arr){
            String[] temp = a.split(",");
            for(String t : temp){
                if(!list.contains(t)){
                    list.add(t);
                }
            }
        }
        answer = new int[list.size()];
        int i = 0;
        for(String l : list){
            answer[i++] = Integer.parseInt(l);
        }
        return answer;
    }
}