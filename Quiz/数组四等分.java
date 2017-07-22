// 数组切三刀，切分位置扔掉，分成的四段要求和相等。判断该数组是否能够四等分，要求时间O(N)

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] data = {1, 8, 5, 2, 7, 9, 3, 6, 12, 8, 1};
        System.out.println(divide(data));
    }

    private static boolean divide(int[] nums) {

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();  // 保存和及其对应的位置

        int sum = 0;
        for (int i = 0; i < len; i++) {

            sum += nums[i];
            map.put(sum, i + 1);
        }

        int left = 1, right = len - 2;
        int lsum = nums[0], rsum = nums[len - 1];

        while (left < right) {

            if (lsum == rsum) {

                int x = 2 * lsum + nums[left];
                int y = sum - (2 * rsum + nums[right]);

                if (map.get(x) != null && map.get(y) != null && map.get(x) + 1 == map.get(y))
                    return true;
                else {

                    lsum += nums[left++];
                    rsum += nums[right--];
                }
            }

            if (lsum < rsum) lsum += nums[left++];
            else if (lsum > rsum) rsum += nums[right--];
        }

        return false;
    }
}
