public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N = nums1.length + nums2.length;
        // 找规律，L的下标为(N-1)/2，R的下标为N/2
        int i = (N + 1) / 2, j = (N + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, i) + getKth(nums1, 0, nums2, 0, j)) / 2.0;
    }

    // 二分法
    private int getKth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (s1 >= nums1.length) return nums2[s2 + k - 1];
        if (s2 >= nums2.length) return nums1[s1 + k - 1];
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);

        // 比较nums1和nums2中的前k/2个数，但要注意数组中剩余的总数
        int i = Math.min(nums1.length - s1, k / 2);
        int j = Math.min(nums2.length - s2, k / 2);

        if (nums1[s1 + i - 1] < nums2[s2 + j - 1]) return getKth(nums1, s1 + i, nums2, s2, k - i);  // 抛弃nums1中的前i个数
        else return getKth(nums1, s1, nums2, s2 + j, k - j);  // 抛弃nums2中的前j个数
    }
}