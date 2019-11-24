package algorithm.zuoChengYun.生成窗口最大值数组;

// 复杂度 O(N * w)
public class DoV1 {

    // N = allArr.length
    static int[] allArr = {4,3,5,4,3,3,6,7};

    public static void main(String[] args) {

        // w = windowSize
        int windowSize = 3;

        int[] resArr = new int[allArr.length - windowSize +1];

        for (int i = 0; i < allArr.length - 2; i++) {
            int max = allArr[i];
            max = compare(max, allArr[i+1]) ? max : allArr[i+1];
            max = compare(max, allArr[i+2]) ? max : allArr[i+2];
            resArr[i] = max;
        }

        for (int i : resArr) {
            System.out.print(i);
            System.out.print("  ");
        }

    }

    private static boolean compare(int a, int b){
        return a > b;
    }

}
