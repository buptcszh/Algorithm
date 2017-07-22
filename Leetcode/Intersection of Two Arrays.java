public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> s1 = new HashSet<>();
        for (int i : nums1) {

            s1.add(i);
        }

        Set<Integer> s2 = new HashSet();
        for (int i : nums2) {

            if (s1.contains(i)) s2.add(i);
        }

        int[] result = new int[s2.size()];
        int i = 0;
        for (int num : s2) {

            result[i++] = num;  // Set没有get(int)方法
        }
        return result;
    }
}
