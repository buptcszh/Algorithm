// 每瓶啤酒2元，2个空酒瓶或4个瓶盖可换1瓶啤酒。10元最多可喝多少瓶啤酒？

import java.util.Scanner;

public class Main {

    private static int leftBottle;
    private static int leftCap;
    // 不能赊账
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 初始n=10/2=5瓶
        int n = sc.nextInt();

        System.out.println(n + change(n, n));
    }

    // 计算可以换回多少瓶
    private static int change(int bottle, int cap) {

        if (bottle / 2 == 0 && cap / 4 == 0) return 0;

        int x = bottle / 2 + cap / 4;
        leftBottle = x + bottle % 2;
        leftCap = x + cap % 4;

        return x + change(leftBottle, leftCap);
    }
}

/*
如果可以赊账的话：
设酒价值x，瓶价值y，盖价值z，那么有
x+y+z=2
2y=2
4z=2

解得x=0.5，那么10/0.5=20瓶酒
*/
