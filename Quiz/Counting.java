// 计数排序 限制：需要已知元素的范围，且每个元素必须是非负的
// 时间复杂度O(n)，空间复杂度O(n)，稳定

public class Counting {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 0, 3, 1, 0, 1, 1};  // 数据范围[0-3]

        int[] res = new int[nums.length];
        int[] aux = new int[4];

        for (int i = 0; i < nums.length; i++) {

            aux[nums[i]]++;
        }

        for (int i = 1; i < aux.length; i++) {

            aux[i] = aux[i-1] + aux[i];
        }

        // 此时aux[i]表示小于等于i的元素个数, 那么nums[i]肯定在aux[nums[i]]-1这个位置上
        // 从后往前遍历可以保证排序是稳定的
        for (int i = nums.length - 1; i >= 0 ; i--) {

            res[aux[nums[i]]-1] = nums[i];
            aux[nums[i]]--;  // 因为已经输出这个数了
        }

        for (int i = 0; i < res.length; i++) {

            System.out.println(res[i]);
        }
    }

}
