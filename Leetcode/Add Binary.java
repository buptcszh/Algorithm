public class Solution {
    public String addBinary(String a, String b) {

        int lenA = a.length();
        int lenB = b.length();
        int p = 0, q;
        int i, j;
        StringBuilder sb = new StringBuilder();

        for (i = lenA-1, j = lenB-1; i >= 0 && j >= 0; i--, j--) {

            int sum = Character.digit(a.charAt(i), 2) + Character.digit(b.charAt(j), 2) + p;
            p = sum / 2;
            q = sum % 2;
            sb.append(q);
        }

        int t = i > j ? i : j;
        while (t >= 0) {

            if (p != 0) {

                int sum = Character.digit(i > j ? a.charAt(t--) : b.charAt(t--), 2) + p;
                p = sum / 2;
                q = sum % 2;
                sb.append(q);
            } else sb.append(i > j ? a.charAt(t--) : b.charAt(t--));
        }
        if (p != 0) sb.append(p);

        return sb.reverse().toString();
    }
}