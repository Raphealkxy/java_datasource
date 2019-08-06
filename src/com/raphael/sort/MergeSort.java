package com.raphael.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sort
 * @date:2019/8/6
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];//归并排序需要一个额外的空间
        int arr1[]=new int[80000];
        // mergeSort(arr,0,arr.length-1,temp);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = simpleDateFormat.format(date);
        System.out.println(dateString1);
        for(int i=0;i<80000;i++){
            arr1[i]= (int) (Math.random()*8000000);
        }
        mergeSort(arr1,0,arr.length-1,temp);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1  =new SimpleDateFormat("yyyy-MM-d HH:mm:ss");
        String dateString2 = simpleDateFormat.format(date2);
        System.out.println(dateString2);
        System.out.println("归并排序后="+ Arrays.toString(arr));
    }

    //合并方法


    //分+和方法
    public static void mergeSort(int [] arr,int left,int right,int [] temp){
//        System.out.println("分");
        if(left<right){
            int mid = (left+right)/2;//中间索引
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //向右递归分解
            mergeSort(arr,mid+1,right,temp);

            //到合并
            merge(arr,left,mid,right,temp);
        }
    }
    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid  中间索引
     * @param right 右边数组
     * @param temp 做中转的数组
     */
    public static void merge(int [] arr,int left,int mid,int right,int [] temp){
        System.out.println("治");
        int i =left;//初始化i，左边有序序列的初始索引
        int j = mid+1;//初始化j,右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引

        //(一）
        //先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while(i<=mid&&j<=right){
            //如果左边的有序序列的当前元素，小于等于右边的有序序列的当前元素
            //即将左边的当前元素，拷贝到temp数组
            //然后t++,i++
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t++;
                i++;
            }else {
                temp[t]=arr[j];
                t++;
                j++;
            }
        }

        //(二）
        //把剩余一边的数据一次全部填充到temp
        while(i<=mid){//左边的有序序列还有剩余的元素 就全部填充到temp
            temp[t]=arr[i];
            t++;
            i++;
        }

        while(j<=right){//右边的有序序列 还有剩余元素 就全部填充到temp
            temp[t]=arr[j];
            t++;
            j++;
        }
        //(三）
        //将temp数组的元素拷贝到arr
        //注意：并不是每次都要拷贝所有 比如第一次的时候，拷贝2个
        t=0;
        int tempLeft =left;
        while (tempLeft<=right){//第一次合并时templeft=0,right =1;//最后一次 tempLeft =0 right=7
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }

    }
}
