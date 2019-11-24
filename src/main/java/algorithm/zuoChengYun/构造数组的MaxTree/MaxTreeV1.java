package algorithm.zuoChengYun.构造数组的MaxTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxTreeV1 {

    public static void main(String[] args) {

        int[] arr = {3,4,5,1,2};
        Node[] nodes = new Node[arr.length];
        for (int i=0; i < nodes.length; i++) {
            nodes[i] = new Node(arr[i]);
        }

        Stack<Node> stack = new Stack<>();

        // 节点与比该节点大的左边第一个数
        Map<Node, Node> leftMap = new HashMap<>();

        for (int i = 0; i < nodes.length; i++) {
            while (!stack.isEmpty() && stack.peek())
        }

    }

//    public static Node getMaxTree(int[] arr){
//
//    }

}
