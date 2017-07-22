public class Solution {

    public static void main(String[] args) {

        System.out.println(gcd(3, 15));
    }

    // 要求a、b是两个正整数
    private static int gcd(int a, int b) {

        return b == 0 ? a : gcd(b, a % b);
    }
}

/*
已知a/b = k...r (即r = a - kb)，证明：gcd(a, b) = gcd(b, r)
证明：
假设gcd(a, b) = c，则a = mc，b = nc
那么r = (m - kn)c，即c也是r的约数，下面只需证明(m - kn)与n互质
反证法：
假设n = xd，m - kn = yd (d > 1)
那么a = (kn + yd)c = (kx + y)dc，b = xdc，即dc也是a、b的约数，且比c大，矛盾
得证
*/
