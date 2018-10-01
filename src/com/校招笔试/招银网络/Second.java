package com.校招笔试.招银网络;

/**
 * Created by lzl on 2018/9/8 14:31
 * 功能：客户排序
 */
public class Second {

    /**
     * 订单
     */
    class Order {
        public String custName;// 客户名
        public Order(String custName) {
            this.custName = custName;
        }
    }

    class CustSort {
        public Order[] flow; // 记录订单流水
        public int total; // 总客户数
        public int current; // 当前订单

        public CustSort(int total) {
            this.total = total;
            current = 0;
//            flow = new Order[__【1 】__];
            flow = new Order[total];
        }

        /**
         * 生成订单
         * @param custName
         */
        public boolean createOrder(String custName) {
            Order newOrder = new Order(custName);
            flow[current] = newOrder;
//            moveUp(__【2 current】__);
            moveUp(current);
            return true;
        }

        /**
         * 向上调整，使各节点的值不大于其双亲节点
         * @param index
         */
        public void moveUp(int index) {
            int parent = (index - 1) / 2;
            Order bottom = flow[index];
//            while (index > 0 && flow[parent].custName.compareTo(__【3 index】__) < 0) {
              while (index > 0 && flow[parent].custName.compareTo(flow[parent].custName) < 0) {
                flow[index] = flow[parent];
                index = parent;
//                parent = (__【4】__) / 2;
                  parent = (index)/2;
            }
            flow[index] = bottom;
        }

        /**
         * 获取并删除
         */
        public Order get() {
            Order root = flow[0];
//            flow[0] = flow[__【5 current】__];
            flow[0] = flow[current];
            moveDown(0);
            return root;
        }

        /**
         * 向下调整，是堆顶元素不小于子节点的值
         * @param index
         */
        public void moveDown(int index) {
            int largeChild;
            Order top = flow[index];
            while (index < current / 2) {
//                int leftChild = __【6 2】__* index + 1;
                int leftChild = 2 * index + 1;
                int rightChild = leftChild + 1;
//                if (rightChild < __【7 index】__
                if(rightChild < index
                        && flow[leftChild].custName.compareTo(flow[rightChild].custName) < 0) {
                    largeChild = rightChild;
                } else {
                    largeChild = leftChild;
                }
                if (top.custName.compareTo(flow[largeChild].custName) >= 0) {
                    break;
                }
                flow[index] = flow[largeChild];
                index = largeChild;
            }
            flow[index] = top;
        }
    }
}
