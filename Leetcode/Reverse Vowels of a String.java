public class Solution {
    public String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder(s);
        String vowels = "aeiouAEIOU";

        int i = 0, j = s.length() - 1;
        while (i < j) {

            while (i < j && !vowels.contains(sb.charAt(i) + "")) i++;
            while (i < j && !vowels.contains(sb.charAt(j) + "")) j--;

            char c = sb.charAt(j);
            sb.setCharAt(j, sb.charAt(i));
            sb.setCharAt(i, c);

            i++;
            j--;
        }

        return sb.toString();
    }
}
