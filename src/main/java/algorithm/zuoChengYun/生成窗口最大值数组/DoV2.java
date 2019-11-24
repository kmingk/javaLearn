package algorithm.zuoChengYun.生成窗口最大值数组;

import java.util.LinkedList;

// 复杂度 O(N)
public class DoV2 {

    // N = allArr.length
    static int[] allArr = {4,3,5,4,3,3,6,7};

    public static void main(String[] args) {

        DoV2 doV2 = new DoV2();
        int[] res = doV2.getMaxWindow(allArr, 3);

        for (int re : res) {
            System.out.println(re);
        }

    }

    public int[] getMaxWindow(int[] arr, int w){
        if(null == arr || w < 1 || w > arr.length){
            return null;
        }

        // 存储的是数组索引
        // 模拟双端队列
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];

        int index = 0;
        for(int i =0; i< arr.length; i++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            // i = qmax.peekFirst() + w
            //当qmax.peekFirst() = 2， w = 3时，
            // i = 5时，此时索引2已经没用，比较的是索引3,4,5
            if(qmax.peekFirst() == i -w){
                qmax.pollFirst();
            }

            if(i >= w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }

        return res;
    }

}
