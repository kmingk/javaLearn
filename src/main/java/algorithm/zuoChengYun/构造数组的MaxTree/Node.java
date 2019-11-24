package algorithm.zuoChengYun.构造数组的MaxTree;

import lombok.Data;

@Data
public class Node {

    private int data;
    private Node left;
    private Node right;

    public Node(int data){
        this.data = data;
    }

}
