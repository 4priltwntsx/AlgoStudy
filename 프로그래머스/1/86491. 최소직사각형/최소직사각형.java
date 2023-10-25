class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int height = 0;
        
        for(int[] size : sizes){
            int w = size[0]>size[1] ? size[0] : size[1];
            int h = size[0]<=size[1] ? size[0] : size[1];
            
            if(width<w) width =w;
            if(height<=h) height = h;
        }
        answer = width*height;
        return answer;
    }
}