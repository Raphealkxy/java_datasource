package com.raphael.search;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.search
 * @date:2019/8/7
 */
public class SeqSearch {

    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,34,89};//没有顺序的数组
        int index =seqSearch(arr,11);
        if(index==-1){
            System.out.println("没有查找到查找的值");
        }else {
            System.out.println("找到，下标为="+index);
        }
    }

    /**
     * 这里实现的线性查找是找到一个满足条件的值就返回，如果要求找到所有的，就用集合返回
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int []arr,int value){
        //线性查找是逐一比对，发现有相同的值时，就返回下标
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
