package com.raphael.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.search
 * @date:2019/8/7
 */
//注意：使用二分查找的前提是该数组是有序的
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] ={1,8,10,89,1000,1000,1000,1234};
       // int resultIndex = binarySearch(arr,0,arr.length-1,88);
      //  System.out.println("resIndex="+resultIndex);

        List resultIndexList = binarySearch2(arr,0,arr.length-1,1000);
        System.out.println("resIndexList="+resultIndexList);
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
    //完成一个课后思考题
    /**
     * 找到所有满足情况的下标
     * 思路：在找到mid时，不要马上返回
     *      向mid索引值的左边扫描，将所有满足查找的值的下标的将入到一个集合中ArrayList
     *      向mid索引值的右边扫描 将所有满足查找的值的下标都加入到集合中
     */
    public static ArrayList<Integer> binarySearch2(int []arr, int left, int right, int findval){

        //当left>rigth时，说明递归整个数组，但是没有找到  递归栈 是一条直线
        if(left>right){
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if(findval>midVal){
            //向右递归
            return binarySearch2(arr,mid+1,right,findval);
        }else if(findval<midVal){
            return  binarySearch2(arr,left,mid-1,findval);
        }else {
            ArrayList<Integer>resIndexList=new ArrayList<Integer>();
            int temp =mid-1;
            //向mid左边扫描
            while (true){
                    if(temp<0||arr[temp]!=findval){
                        break;
                    }
                    //否则，就放入到list集合中
                    resIndexList.add(temp);
                    temp-=1;
                }
            resIndexList.add(mid);//

            //向mid右边扫描
            temp=mid+1;
            while (true){
                if(temp>arr.length-1||arr[temp]!=findval){
                    break;
                }

                resIndexList.add(temp);
                temp+=1;
            }
            return resIndexList;
        }

    }
}
