public class Solution {
    public String convertToTitle(int n) {
        String[] tab = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
                        "J", "K", "L", "M", "N", "O", "p", "Q", "R",
                        "S", "T", "U", "V", "W", "X", "Y", "Z"};

        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            n--;
            sb.append(tab[n % 26]);
            n /= 26;
        }

        return sb.reverse().toString();
    }
}
