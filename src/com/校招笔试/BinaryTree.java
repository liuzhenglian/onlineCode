package com.校招笔试;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现二叉树前序、中序、后序和层次遍历
 * 理解：遍历本质上是一种寻址操作
 * 从每一个节点考虑，节点需要知道自己的左右找子树和数值
 */


public class BinaryTree {

    public static void main(String[] args){
        // 先左子树后右子树
        System.out.println("ok");
//        创建一棵二叉树：需要在遍历的过程中判断左右子树是否为0
//        定义一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree binaryTree2 = new BinaryTree();
        Object []tree = {1,2,3};
        binaryTree.creatTree(tree);
        binaryTree2.preorder(binaryTree);
    }

    private BinaryTree leftChild;
    private BinaryTree rightChild;
    private BinaryTree root;
    private Object data;
    private List<BinaryTree> datas;


    public BinaryTree (BinaryTree leftChild, BinaryTree rightChild, Object data) {
        super();
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public BinaryTree (Object data) {
        this(null, null, data);
    }

    public BinaryTree(){
        super();
    }

    //    创建二叉树
    public void creatTree(Object[] objs){
        datas = new ArrayList<BinaryTree>();
        for (Object object :objs){
            datas.add(new BinaryTree(object));
        }
        root = datas.get(0);//将第一个作为根节点
        for(int i = 0; i < objs.length/2; i++){
            datas.get(i).leftChild = datas.get(i * 2 + 1);
            if(i * 2 + 2 < datas.size()){//避免偶数的时候，下标越界
                    datas.get(i).rightChild = datas.get(i * 2 + 2);
            }
        }
    }


    private void visit(Object obj){
        System.out.println(obj + " ");
    }

    public Object getData(){
        return data;
    }

    public BinaryTree getRoot(){
        return root;
    }

    //    先序遍历
    public void preorder(BinaryTree root){
        if(root != null){
            visit(root.getData());
            preorder(root.leftChild);
            preorder(root.rightChild);
        }
    }
    //    中序遍历
    public void inorder(BinaryTree root){
        if(root != null){
            inorder(root.leftChild);
            visit(root.getData());
            inorder(root.rightChild);
        }
    }

    //    后序遍历
    public void afterorder(BinaryTree root){
        if(root != null){
            afterorder(root.leftChild);
            afterorder(root.rightChild);
            visit(root.getData());
        }
    }

    //    前序遍历(非递归实现)
    public void preOrder2(BinaryTree root){
        LinkedList<BinaryTree> stack = new LinkedList<>();
        BinaryTree node = root;
        while(node != null || !stack.isEmpty()){
            if(node != null){
                System.out.println(node.data + " ");
                stack.push(node);
                node = node.leftChild;
            }else{
                BinaryTree node1 = stack.pop();
                node = node.rightChild;
            }
        }
    }
}
