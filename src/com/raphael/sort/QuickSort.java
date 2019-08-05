package com.raphael.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sort
 * @date:2019/8/5
 */
public class QuickSort {

    public static void main(String[] args) {
        int []arr = {-9,78,0,23,-567,70,-1,900,4561};
        int []arr1 = new int[80000];
        for(int i=0;i<80000;i++){
            arr1[i]=(int)(Math.random()*8000000);
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是="+date1Str);
//        quickSort(arr1,0,arr.length-1);
        quickSort(arr1,0,arr.length-1);
        Date data2 = new Date();
        String date1Str2 = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是="+date1Str2);
        System.out.println(Arrays.toString(arr1));
        System.out.println("arr="+Arrays.toString(arr));
    }


    public static void quickSort(int [] arr,int left,int right){
        int l = left;//左下标
        int r = right;//右下标
        //pivot 中轴
        int pivot = arr[(left+right)/2];//0 5  ---2
        //while循环的目的是比让pivot值放左边 比pivot大的值放到右边
        //临时变量
        int temp =0;
        while(l<r){

            //在pivot左边一直找 找到大于等于pivot，才退出
            while(arr[l]<pivot){
                l+=1;
            }
            //在pivot右边一直找 找到小于等于pivot的值 才退出
            while (arr[r]>pivot){
                     r-=1;
            }
            //如果l>=r说明pivot的左右两的值 已经按照左边全部是
            //左边全部是小于等于pivot的值 右边全部是大于pivot值
            if(l>=r){
                break;
            }
            //交换
             temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //如果交换完后，发现这个arr[l]==pivot值 相等--，前移
            if(arr[l]==pivot){
                r-=1;
            }
            //如果交换完后，发现这个arr[r]==pivot值 相等 l-- 后移
            if(arr[r]==pivot){
                l+=1;
            }
        }

        //如果l==r 必须l++,r--,否则为出现栈溢出
        if(l==r){
            l+=1;
            r-=1;
        }

        //向左递归
        if(left<r){
            quickSort(arr,left,r);
        }
        //向右递归
        if(right>l){
            quickSort(arr,l,right);
        }
    }
}
