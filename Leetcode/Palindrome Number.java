public class Solution {
    public boolean isPalindrome(int x) {
        
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;  // 10、100这样的数需要特殊考虑
        
        int res = 0;
        while (res < x) {  // reverse到一半就可以了
            
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (res == x || res / 10 == x);
    }
}