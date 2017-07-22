public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 1) return findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1);
        else return (findKth(nums1, 0, nums2, 0, (m + n) / 2) + findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1)) / 2.0;
    }

    // 在两个有序数组中求第k大的数，分治法
    private int findKth(int[] nums1, int pos1, int[] nums2, int pos2, int k) {

        if (pos1 >= nums1.length) return nums2[pos2 + k - 1];
        if (pos2 >= nums2.length) return nums1[pos1 + k - 1];
        // 终止条件
        if (k == 1) return Math.min(nums1[pos1], nums2[pos2]);

        int mid1 = pos1 + k / 2 - 1 < nums1.length ? nums1[pos1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = pos2 + k / 2 - 1 < nums2.length ? nums2[pos2 + k / 2 - 1] : Integer.MAX_VALUE;

        // 如果nums1中第k/2大的数 < nums2中第k/2大的数，那么nums1中的前k/2个数都不可能是合并后的第k大的数
        // 如果nums1中第k/2大的数 > nums2中第k/2大的数，同理
        // 如果nums1中第k/2大的数 = nums2中第k/2大的数 = m
        // k为偶数时，m即合并后的第k大的数; k为奇数时，nums1中的前k/2个数和nums2中的前k/2个数都不可能是合并后的第k大的数
        if (mid1 < mid2) pos1 += k / 2;
        else pos2 += k / 2;  // mid1 = mid2时，去掉任意一个数组中的前k/2个数都可以

        return findKth(nums1, pos1, nums2, pos2, k - k / 2);
    }
}
