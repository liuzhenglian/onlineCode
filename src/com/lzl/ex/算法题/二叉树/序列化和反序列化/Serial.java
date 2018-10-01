package com.lzl.ex.算法题.二叉树.序列化和反序列化;


/**
 * 2018-8-26
 * 类的功能说明：通过先序遍历和层遍历两种方法实现二叉树的序列化和反序列化
 *解释说明：
 * （1）序列化：二叉树被记录成文件的过程叫做二叉树的序列化,序列化的方法需要保证二叉树的唯一性
 * （2）反序列化：通过文件内容重建原来的二叉树的过程叫做二叉树的反序列化
 */


public class Serial {
    /**
     * @param head:先序遍历就是先根遍历，head就是二叉树数据
     * @return
     */
    public String serialByPre(Node head){
        if(head == null){
            return "#!";
        }
        String temp = head.value + "!";
        temp += serialByPre(head.left);
        temp += serialByPre(head.right);
        return temp;
    }
    public class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){this.value = data;}
    }
}


