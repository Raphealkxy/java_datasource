package com.raphael.search;

import java.util.Arrays;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.search
 * @date:2019/8/7
 */
public class InsertValue {
    public static void main(String[] args) {
        int [] arr = new int[100];
        for(int i=0;i<100;i++){
            arr[i]=i+1;
        }
       int goalindex = insertValueSearch(arr,0,arr.length-1,99);
        System.out.println("index="+goalindex);
    }

    //编写插值查找算法
     //说明：插值查找算法，也要求数组是有序的
    /**
     *
     * @param arr 数组
     * @param left 左边索引
     * @param rigtht 右边索引
     * @param findVal 查找值
     * @return 如果找到，返回对应的下标 如果没有找到，返回-1
     */
    public static int insertValueSearch(int [] arr,int left,int rigtht,int findVal){
        System.out.println("查找次数");
        if(left>rigtht||findVal<arr[0]||findVal>arr[arr.length-1]){
            return -1;
        }
        //求出mid 自适应查找
        int mid = left+(rigtht-left)*(findVal-arr[left])/(arr[rigtht]-arr[left]);
        int midVal =arr[mid];
        if(midVal>midVal){//说明应该向右边递归查找
           return insertValueSearch(arr,mid+1,rigtht,findVal);
        }else if(midVal<midVal){
            return insertValueSearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }
    }
}
