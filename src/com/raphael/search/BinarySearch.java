package com.raphael.search;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.search
 * @date:2019/8/7
 */
//注意：使用二分查找的前提是该数组是有序的
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] ={1,8,10,89,1000,1234};
        int resultIndex = binarySearch(arr,0,arr.length-1,88);
        System.out.println("resIndex="+resultIndex);
    }

    //二分查找算法

    /**
     *
     * @param arr
     * @param left 左边索引
     * @param right 右边索引
     * @param findval 要查找的值
     * @return 如果没有找到，就返回-1
     */
    public static int binarySearch(int []arr,int left,int right,int findval){

        //当left>rigth时，说明递归整个数组，但是没有找到  递归栈 是一条直线
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if(findval>midVal){
            //向右递归
            return binarySearch(arr,mid+1,right,findval);
        }else if(findval<midVal){
            return  binarySearch(arr,left,mid-1,findval);
        }else {
            return mid;
        }
    }
}
