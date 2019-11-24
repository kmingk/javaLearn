package algorithm.zuoChengYun.生成窗口最大值数组;

import java.util.LinkedList;

// 复杂度 O(N)
public class DoV2Me {

    // N = allArr.length
    static int[] allArr = {4,3,5,4,3,3,6,7};

    public static void main(String[] args) {

        DoV2Me doV2Me = new DoV2Me();
        int[] res = doV2Me.getMaxWindow(allArr, 3);
        for (int re : res) {
            System.out.println(re);
        }

    }

    private int[] getMaxWindow(int[] arr, int w){

        // check
        if(null == arr || w < 1 || arr.length < w){
            return null;
        }

        // 模拟双端队列
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w +1];

        int resIndex = 0;
        // 注意遍历的是索引
        for (int arrIndex=0; arrIndex < arr.length; arrIndex++) {
            while (!qmax.isEmpty() && arr[qmax.peekFirst()] <= arr[arrIndex]){
                qmax.pollFirst();
            }

            qmax.add(arrIndex);

            // 去除w个以外的索引
            if(qmax.peekFirst() == arrIndex - w){
                qmax.pollFirst();
            }

            if(arrIndex >= w-1){
                res[resIndex++] = arr[qmax.peekFirst()];
            }

        }

        return res;

    }


}
