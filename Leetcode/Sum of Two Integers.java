public class Solution {
    public int getSum(int a, int b) {
        
        int ans = a ^ b;  // 不考虑进位的结果
        int carry = a & b;  // 每一位的进位
        
        while (carry != 0) {
            
            carry = carry << 1;
            int temp = ans ^ carry;
            carry = ans & carry;
            ans = temp;
        }
        
        return ans;
    }
}