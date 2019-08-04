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
public class BubbleSortModify {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,20};
        BubbleSort(arr);

        //测试冒泡排序的数度O(n^2) 给80000个数据 测试
        //创建要给80000个随机的数组
        int []arr1 = new int[80000];
        for(int i=0;i<80000;i++){
            arr1[i]=(int)(Math.random()*8000000);
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是="+date1Str);
        BubbleSort(arr1);
        Date data2 = new Date();
        String date1Str2 = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是="+date1Str2);
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        //为了容易理解，我们把冒泡排序的演变过程
        //第一趟，把最大的排在最后
        //
    }

    public static void BubbleSort(int arr[]){
        int temp=0;//交换的临时变量
        boolean flag =false;//识别变量 表示是否进行过交换
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++) {
                //如果前面的数比后面的数大，则交换，如果不大，不交换
                if (arr[j] > arr[j + 1]) {
                    flag=true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第"+(i+1)+"趟排序后的数组为");
//            System.out.println(Arrays.toString(arr));
            if(!flag){//在一趟排序中，有一次交换都没有发生过
                break;
            }else {
                flag = false;//重置flag 进行下次判断
            }

        }
    }
}
