package com.raphael.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sort
 * @date:2019/8/5
 */
public class ShellSort {

    public static void main(String[] args) {
        int arr[]={8,9,1,7,2,3,5,4,6,0};
        //使用逐步推导的方式来编写希尔排序
        //shellSort(arr);
       // System.out.println(Arrays.toString(arr));
       // shellSortReal(arr);
        int arr1[]=new int[80000];
        Date date = new Date();
        SimpleDateFormat simpleDateFormat  =new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        String dateString1 = simpleDateFormat.format(date);
        System.out.println(dateString1);
        for(int i=0;i<80000;i++){
            arr1[i]= (int) (Math.random()*8000000);
        }
       // shellSort(arr1);
        shellSort2(arr1);
        System.out.println(Arrays.toString(arr1));
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1  =new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        String dateString2 = simpleDateFormat.format(date2);
        System.out.println(dateString2);
    }

    //使用逐步推导的方式来编写希尔排序 //交换法
    public static void shellSort(int []arr){
        int temp =0;
        //希尔排序的第1轮排序
        //因为第1轮排序，是将10个数据分层5组
        //i从5开始
        for(int i=5;i<arr.length;i++){
            for(int j=i-5;j>=0;j-=5){
                if(arr[j]>arr[j+5]){
                    temp=arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }

        //第二轮
        for(int i=2;i<arr.length;i++){
            for(int j=i-2;j>=0;j-=2){
                if(arr[j]>arr[j+2]){
                    temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
            }
        }


        //第三轮
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j-=1){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

    }

    //根据逐步分析 使用循环处理 交换法 分组进行直接排序
    public static  void shellSortReal(int [] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            int temp = 0;
            //希尔排序的第1轮排序
            //因为第1轮排序，是将10个数据分层5组
            //i从5开始
            //这种方式建立的一个机制
            for (int i = gap; i < arr.length; i++) {//组计数 中间开始
                for (int j = i - gap; j >= 0; j -= gap) {//每组
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

            System.out.println("希尔排序"+Arrays.toString(arr));
        }
    }


   //希尔排序 移动法 分组进行插入排序
    public static void shellSort2(int [] arr){

        //增量gap 并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素 逐个对其所在的组进行直接插入排序
           for(int i=gap;i<arr.length;i++){
                int j=i;
                int temp =arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0&&temp<arr[j-gap]){
                        //移动
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    //当退出while循环后，就给temp找到插入的位子
                    arr[j]=temp;
                }
            }
        }
    }
}
