package com.raphael.sort;

import java.util.Arrays;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sort
 * @date:2019/8/4
 */
public class InsertSort {

    public static void main(String[] args) {
             int arr[] = {101,34,119,1,-1,89};
             insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int [] arr){
        //使用逐步推导的方式
        //初始状态 101
        //第一轮 34 第二轮 119 第三轮 1
        //使用for循环来吧代码化简
        for(int i=1;i<arr.length;i++){
            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i-1;//即arr[i]前面这个数的下标
            //给insertVa;找到插入位置
            //说明
            //1.insertIndex>=0 保证在给insertVal找插入位置 不越界
            //2.insertVal<arr[insertIndex]
            while(insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
            // for(int i=1;i<)
            //  int insertVal =arr[1];
            //  int insertindex =1-1;
            System.out.println("第"+i+"轮排序后");
            System.out.println(Arrays.toString(arr));
        }




    }
}
