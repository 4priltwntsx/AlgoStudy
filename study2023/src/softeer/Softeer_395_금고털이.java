package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Softeer_395_금고털이 {
    static class Item implements Comparable<Item>{
        int w, p;
        Item(int w, int p){
            this.w = w;
            this.p = p;
        }
        
        public int compareTo(Item o){
            return o.p - this.p;
        }

    } 
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Item> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int profit = Integer.parseInt(st.nextToken());
            list.add(new Item(weight, profit));
        } // input end

        Collections.sort(list);

        int result = 0;
        for(Item item : list){
            int profit = item.p;
            int weight = item.w;
            if(W-weight >= 0){
                W-=weight;
                result += (weight*profit);
            }
            else{
                result += (W * profit);
                break;
            }
        }
        System.out.print(result);
    }
}
