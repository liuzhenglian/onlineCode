package com;

import java.util.Comparator;

/**
 * Created by lzl on 2018/9/11 0:51
 * 功能：
 */
public class MyCode {
    //比较Comparable和Comparator的区别

    //Comparable是内比较器，需要在类内部实现compareTo方法
    static class  Domain implements Comparable<Domain>{
        private String str;
        public Domain(String str){
            this.str = str;
        }

        //当前对象和其他对象进行值的比对,开发者自己定义比较规则
        public int compareTo(Domain domain) {
            if (this.str.compareTo(domain.str) > 0) return 100;
            else if (this.str.compareTo(domain.str) == 0) return 0;
            else
                return -100;
        }
            public String getStr(){
                return str;
            }
        }

        //Comparator是一个外比较器，无需在参与比较的类中进行实现，需要额外一个类中进行实现
        static class DomainComparator implements Comparator<Domain> {
        public int compare(Domain domain1, Domain domain2){
            if(domain1.getStr().compareTo(domain2.getStr()) > 0){
                return 1;
            }

            else if(domain1.getStr().compareTo(domain2.getStr()) == 0){
                return 0;
            }
            else
                return -1;
        }

        }
    public static void main(String[] args) {
        Domain d1 = new Domain("C");
        Domain d2 = new Domain("C");
        Domain d3 = new Domain("B");
        Domain d4 = new Domain("D");
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.compareTo(d3));
        System.out.println(d1.compareTo(d4));

        DomainComparator dc = new DomainComparator();
        System.out.println(dc.compare(d1, d2));
        System.out.println(dc.compare(d1, d3));
        System.out.println(dc.compare(d1, d4));
    }
}



