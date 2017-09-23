// 未验证答案是否完全正确
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int f = Integer.valueOf(s[1]);

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] pos = new int[n + 1];  //  记录每个函数下一个调用的位置

        for (int i = 1; i <= n; i++) {
            String[] temp = sc.nextLine().split(" ");
            List<Integer> list = new LinkedList<>();
            for (String str : temp) {
                list.add(Integer.valueOf(str));
            }
            map.put(i, list);
        }

        Stack<Integer> stack = new Stack<>();

        List<Integer> l = map.get(f);
        int p = pos[f];

        while (true) {
            if (stack.contains(f)) {
                System.out.println("E");
                return;
            }

            stack.push(f);  // 放入调用栈

            // 调用返回
            if (l.get(p) == 0) {
                int x = stack.pop();
                if (stack.isEmpty()) {
                    System.out.println("R");
                    return;
                }

                System.out.print(x + " ");

                f = stack.peek();
                l = map.get(f);
                p = pos[f];
            }
            // 异常
            else if (l.get(p) == -1) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                    if (stack.size() > 0) System.out.print(" ");
                }
                System.out.println();
                return;
            }
            // 继续调用
            else {
                pos[f] = p + 1;

                f = l.get(p);
                l = map.get(f);
                p = pos[f];
            }
        }
    }
}