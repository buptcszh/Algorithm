public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序是一个很重要的优化
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        dfs(candidates, target, 0, list, res);
        return res;
    }

    private void dfs(int[] nums, int target, int pos, List<Integer> list, List<List<Integer>> res) {

        if (target == 0) {

            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0) return;

        for (int i = pos; i < nums.length; i++) {

            // i>pos表明pos到i-1都没有放,因此如果i和i-1相同就可以直接剪枝了
            if (i > pos && nums[i] == nums[i - 1]) continue;

            list.add(nums[i]);
            dfs(nums, target - nums[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
