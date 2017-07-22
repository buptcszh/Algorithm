public class Solution {
    public int thirdMax(int[] nums) {

        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer i : nums) {

            if (i.equals(max1) || i.equals(max2) || i.equals(max3)) continue;

            if (max1 == null || i > max1) {

                max3 = max2;
                max2 = max1;
                max1 = i;
            }
            else if (max2 == null || i > max2) {

                max3 = max2;
                max2 = i;
            }
            else if (max3 == null || i > max3) {

                max3 = i;
            }
        }

        return max3 == null ? max1 : max3;
    }

    /*
    public int thirdMax(int[] nums) {

    Queue<Integer> q = new PriorityQueue<>();
    Set<Integer> s = new HashSet<>();

    for (int i : nums) {
        
        if (s.add(i)) {

            q.offer(i);
            if (q.size() > 3) q.poll();
        }
    }

    if (q.size() == 2) q.poll();
    return q.poll();
    }
    */
}
