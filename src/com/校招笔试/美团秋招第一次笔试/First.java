package com.校招笔试.美团秋招第一次笔试;
import java.util.Scanner;
/**
 * Created by: Administrator 2018-09-07 14:08
 * 功能：
 第一题
 给定一张包含N个点、N-1条边的无向连通图，节点从1到N编号，每条边的长度均为1。假设你从1号节点出发并打算遍历所有节点，那么总路程至少是多少？
 输入
 第一行包含一个整数N，1≤N≤100000。
 接下来N-1行，每行包含两个整数X和Y，表示X号节点和Y号节点之间有一条边，1≤X，Y≤N。
 输出
 输出总路程的最小值。

 案例：
 输入
 4
 1 2
 1 3
 3 4
 输出
 4
 Hint
 1->2->1->3->4的路线遍历所有的节点，总路程为4
 */

/**
 *  解题思路是：走完所有的节点类似于深度优先遍历，也就是说出了最后一条路径外，其他的路径都经历了正这走再返回的过程，即走了两编。
 *  舍最后一条路的路径是X，总分支数为n-1，总路径的长度是2 * (n - 1 - X) + X = 2 * (n - 1) - X,当X最大的时候总路径是最小的，
 *  这个转换为了多叉树求深度的问题，多叉树的深度即为求每个节点的深度
 */


public class First {
    private static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        int nodeNum = in.nextInt();
        int[][] node = new int[nodeNum + 5][nodeNum + 5];
        for (int i = 0; i < nodeNum - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            node[a][b] = 1;
        }
        int depth = findDepth(1, node, 0);
        System.out.println(2 * (nodeNum - 1) - depth);
    }

    /**
     *
     * @param k:指定查询节点
     * @param node：二维数组
     */
    public static int findDepth(int k, int[][]node,int depth){
        depth = 0;//记录指定节点可以遍历的最长深度
        int[] max = new int [node.length + 5];
        for (int i = 0; i < node.length ; i++) {
            if(node[k][i] == 1){
                depth++;
                findDepth(i, node, depth);
            }

        }
        return depth;
    }
}


