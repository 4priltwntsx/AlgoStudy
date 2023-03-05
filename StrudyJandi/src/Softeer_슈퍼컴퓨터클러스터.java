import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Softeer_슈퍼컴퓨터클러스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int b = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        long[] num_list = new long[n];
        for (int i = 0; i < n; i++) {
            num_list[i] = Long.parseLong(input2[i]);
        }

        Arrays.sort(num_list);
        long left = num_list[0];
        long right = 2000000000;

        Map<Long, Integer> num_dict = new HashMap<>();
        for (long i : num_list) {
            if (num_dict.containsKey(i)) {
                num_dict.put(i, num_dict.get(i) + 1);
            } else {
                num_dict.put(i, 1);
            }
        }

        while (right - left > 1) {
        	long mid = (right + left) / 2;
        	long cur_cost = 0;
            boolean isLeft = true;
            for (Map.Entry<Long, Integer> entry : num_dict.entrySet()) {
            	long k = entry.getKey();
            	long v = entry.getValue();
            	
            	
                if (k < mid) {
                    cur_cost += Math.pow(mid - k, 2) * v;

                    if (cur_cost > b) {
                        right = mid;
                        isLeft = false;
                        break;
                    }
                }
            }

            if (isLeft) {
                left = mid;
            }
        }

        System.out.println(left);
    }
}
