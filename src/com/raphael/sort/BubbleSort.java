package com.raphael.sort;

import java.util.Arrays;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sort
 * @date:2019/8/4
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,-2};
        //Ϊ��������⣬���ǰ�ð��������ݱ����
        //��һ�ˣ��������������
        int temp=0;//��������ʱ����
        for(int i=0;i<arr.length-1;i++)
        for(int j=0;j<arr.length-i-1;j++){
           //���ǰ������Ⱥ���������򽻻���������󣬲�����
            if(arr[j]>arr[j+1]){
                temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }

        System.out.println(Arrays.toString(arr));


        //
    }
}
