import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {

        if (str == null) return res;

        dfs(str.toCharArray(), 0);
        Collections.sort(res);

        return res;
    }

    private void dfs(char[] chs, int start) {

        if (start == chs.length - 1) {

            res.add(new String(chs));
            return;
        }

        for (int i = start; i < chs.length; i++) {

            if (i == start || chs[i] != chs[start]) {

              exch(chs, i, start);
            	dfs(chs, start + 1);
            	exch(chs, start, i);
            }
        }
    }

    private void exch(char[] chs, int i, int j) {

        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
