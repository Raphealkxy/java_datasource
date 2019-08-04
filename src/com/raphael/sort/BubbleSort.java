package com.raphael.sort;

import java.util.Arrays;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sort
 * @date:2019/8/4
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,-2};
        //为了容易理解，我们把冒泡排序的演变过程
        //第一趟，把最大的排在最后
        int temp=0;//交换的临时变量
        for(int i=0;i<arr.length-1;i++)
        for(int j=0;j<arr.length-i-1;j++){
           //如果前面的数比后面的数大，则交换，如果不大，不交换
            if(arr[j]>arr[j+1]){
                temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }

        System.out.println(Arrays.toString(arr));


        //
    }
}
