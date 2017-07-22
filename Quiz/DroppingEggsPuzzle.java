public class DroppingEggsPuzzle {
    public static int droppingEggs(int floors, int eggs) {

        int[][] x = new int[floors + 1][eggs + 1];
        for (int i = 1; i < floors + 1; i++) {
            x[i][1] = i;
        }
        for (int i = 1; i < eggs + 1; i++) {
            x[1][i] = 1;
        }

        // x[i][j]表示i层楼,j个鸡蛋时,最坏情况下的最少尝试次数
        // x[i][j] = min{1 + max{x[k-1][j-1], x[i-k][j]}, k = 1,2,...i}
        for (int i = 2; i < floors + 1; i++) {
            for (int j = 2; j < eggs + 1; j++) {

                int min = Integer.MAX_VALUE;

                for (int k = 1; k <= i; k++) {

                    min = Math.min(min, 1 + Math.max(x[k-1][j-1], x[i-k][j]));
                }
                x[i][j] = min;
            }
        }

        return x[floors][eggs];
    }

    public static void main(String[] args) {

        System.out.println(droppingEggs(100, 2));
    }
}
