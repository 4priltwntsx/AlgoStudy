import java.util.Arrays;

public class MaxNumber {
    public static void main(String[] args) {
        int[] nums = {12, 34, 56, 78}; // 예시로 주어진 N자리 정수 M개 배열

        int result = findMaxNumber(nums);
        System.out.println("제일 큰 수: " + result);
    }

    private static int findMaxNumber(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];
        boolean[] used = new boolean[10];

        Arrays.sort(nums);

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int[] digits = getDigits(num);

            boolean valid = true;
            for (int digit : digits) {
                if (used[digit] || (i < n - 1 && digitsContain(nums[i + 1], digit))) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                for (int digit : digits) {
                    used[digit] = true;
                }

                for (int j = 0; j < n; j++) {
                    result[j * 2] = num;
                    result[j * 2 + 1] = nums[j];
                }

                break;
            }
        }

        return buildNumber(result);
    }

    private static int[] getDigits(int num) {
        int[] digits = new int[String.valueOf(num).length()];
        int index = 0;

        while (num > 0) {
            digits[index++] = num % 10;
            num /= 10;
        }

        return digits;
    }

    private static boolean digitsContain(int num, int digit) {
        while (num > 0) {
            if (num % 10 == digit) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

    private static int buildNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result * 10 + num;
        }
        return result;
    }
}
