package com.raphael.recursion;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.recursion
 * @date:2019/7/20
 */
public class RecursionTest {
    public static void main(String[] args) {

        //ͨ����ӡ����ع˵ݹ�ĵ��û���
        test(4);

        int res = factorial(2);
        System.out.println(res);
    }

    //��ӡ����
    public static void test(int n){
        if(n>2){
            test(n-1);
        }//else {
            System.out.println("n=" + n);
       // }
    }

    //�׳�����
    public static int factorial(int n){
        if(n==1){
            return 1;
        }else {
            return factorial(n-1)*n;
        }
    }
}
