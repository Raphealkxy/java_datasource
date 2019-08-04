package com.raphael.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sort
 * @date:2019/8/4
 */
public class SelectSort {

    public static void main(String[] args) {
        int []arr = {101,34,119,1,-1,90,123};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是="+date1Str);
      //  selectSort(arr);
        int []arr1 = new int[80000];
        for(int i=0;i<80000;i++){
            arr1[i]=(int)(Math.random()*8000000);
        }
        selectSort(arr1);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr1));
        Date data2 = new Date();
        String date1Str2 = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是="+date1Str2);
    }

    //选择排序方法
    public static void selectSort(int [] arr){
        //使用逐步推导的方式，来讲解选择排序
        //第1轮
        //原始数据的数组：101,34,119,1

        //第一轮排序 1,34,119,101
        //算法 先简单 做复杂 就是可以把一个复杂的算法 拆分成简单的问题 逐步解决 最后综合

        //选择排序时间复杂度是O(n^2)
        for(int i=0;i<arr.length-1;i++){
          int  minIndex =i;
           int min=arr[i];
            for(int j=i;j<arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }
            if(minIndex!=i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }//如果最小值是每轮循环一开始的。那么没必要和他本身交换
//            System.out.println("第"+(i+1)+"轮后数组序列为");
//            System.out.println(Arrays.toString(arr));
        }

    }
}
