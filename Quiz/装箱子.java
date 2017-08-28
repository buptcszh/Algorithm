import java.util.Scanner;  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int sum = 0;
            int[] u = {0, 5, 3, 1};  // u[i]表示当有i个3*3的产品时，可以用多少个2*2的产品进行填充，u[0]没有用
            int[] s = new int[6];
            for(int i = 0; i < 6; i++) {
                s[i] = sc.nextInt();  
            }
            if(s[0] == 0 && s[1] == 0 && s[2] == 0 && s[3] == 0 && s[4] == 0 && s[5] == 0) break;
            
            // 6*6、5*5、4*4都需要一个盒子，4个3*3可以用一个盒子
            sum = s[5] + s[4] + s[3] + (s[2] + 3) / 4;
            
            // 装有4*4的盒子可以用5个2*2来填充，装有i个3*3的盒子可以用u[i]个2*2来填充
            int y = 5 * s[3] + u[s[2] % 4];  // y表示可以用多少个2*2的盒子填充
            if(s[1] > y) {
                sum += (s[1] - y + 8) / 9;  // 多余的2*2需要用新的箱子，一个箱子可以装9个2*2
            }

            int x = sum * 36 - 36 * s[5] - 25 * s[4] - 16 * s[3] - 9 * s[2] - 4 * s[1];  // x表示可以用多少个1*1的盒子填充
            if(x < s[0]) {
                sum += (s[0] - x + 35) / 36;  // 多余的1*1需要用新的盒子，一个箱子可以装36个1*1
            }
            
            System.out.println(sum);  
        }  
    }  
}