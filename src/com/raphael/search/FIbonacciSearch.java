package com.raphael.search;

import java.util.Arrays;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.search
 * @date:2019/8/9
 */
public class FIbonacciSearch {

    public static int maxSize=20;
    public static void main(String[] args) {
        int [] arr = {1,8,10,89,1000,1234};
        System.out.println(fibSearch(arr,1));

    }
    //因为后面我们mid = low+F(k-1)-1 ，需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
    //非递归方法得到一个斐波那契数列
    public static int[] fib(){
        int [] f= new  int[maxSize];
        f[0]=1;
        f[1]=1;
        for(int i=2;i<maxSize;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    //编写斐波那契查找算法
    //非递归
    /**
     *
     * @param a
     * @param key 需要查找的关键码值
     * @return 返回对应下标，如果没有返回-1
     */
    public static int fibSearch(int []a,int key){
        int low =0;
        int high = a.length-1;
        int k=0;//表示斐波那契数列的分割的数值的下标
        int mid =0;//存放mid值
        int f[] = fib();
        //获取到斐波那契分割数值的下标
        while(high>f[k]-1){
            k++;
        }
        //因为f[k]值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并且指向a
        //如果不足的部分 会使用0填充
        int []temp = Arrays.copyOf(a,f[k]);
        //实际上需要使用a数组的最后的数填充的temp
        //temp={1,8,10,89,1000,1234,0,0,0} =>{1,8,10,89,1000,1234,1234,1234,1234}
        for(int i=high+1;i<temp.length;i++){
            temp[i]=a[high];
        }

        //使用while来循环处理 找到我们的数key
        while (low<=high){
                mid=low+f[k-1]-1;
                if(key<temp[mid]){//我们应该继续数组的前面查找
                        high =mid-1;
                        //为什么是k--;
                        //说明
                       //1.全部元素=前面的元素+后面的元素
                       //2.f[k] = f[k-1]+f[k-2]
                      //因为前面有f[k-1]个元素，所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
                    //即在f[k-1]的前面继续查找k--
                    //即下次循环mid = f[k-1-1]-1
                    k--;
                }else if(key>temp[mid]){//说明应该继续向数组的后面查找（右边）
                    low =mid+1;
                    //
                    k-=2;//个数 //后面的个数//借助图可以容易理解

                }else {
                    //需要
                    if(mid<=high){
                        return mid;
                    }else {
                        return high;
                    }
                }
        }
        return -1;
    }
}
