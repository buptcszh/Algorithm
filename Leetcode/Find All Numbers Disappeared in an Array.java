public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        // 一种tricky的排序方法
        for (int i = 0; i < nums.length; i++) {

            int index = nums[i] - 1;
            while (nums[index] != nums[i]) {

                exch(nums, i, index);
                index = nums[i] - 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) result.add(i + 1);
        }

        return result;
    }

    private void exch(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /*
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -nums[index];
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) result.add(i + 1);
        }

        return result;
    }
    */
}
