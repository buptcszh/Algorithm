public class Solution {

    private int len;

    public List<List<Integer>> fourSum(int[] nums, int target) {

        len = nums.length;
        Arrays.sort(nums);
        return nSum(nums, target, 0, 4);
    }

    private List<List<Integer>> nSum(int[] nums, int target, int start, int n) {

        List<List<Integer>> result = new ArrayList<>();

        if (n == 2) {

            int i = start, j = len - 1;
            while (i < j) {

                if (nums[i] + nums[j] == target) {

                    List<Integer> temp = new ArrayList<>();

                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    result.add(temp);

                    while (i < j && nums[i] == nums[i+1]) i++;
                    while (i < j && nums[j] == nums[j-1]) j--;
                    i++;
                    j--;
                }
                else if (nums[i] + nums[j] < target) i++;
                else j--;
            }
        }
        else {

            for (int i = start; i <= len - n; i++) {

                List<List<Integer>> temp = nSum(nums, target - nums[i], i + 1, n - 1);
                if (!temp.isEmpty()) {

                    for (List<Integer> l : temp) {

                        l.add(0, nums[i]);
                    }
                    result.addAll(temp);
                }

                while (i < len - 1 && nums[i] == nums[i+1]) {

                    i++;
                }
            }
        }

        return result;
    }
}
