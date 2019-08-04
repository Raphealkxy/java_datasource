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
        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����="+date1Str);
      //  selectSort(arr);
        int []arr1 = new int[80000];
        for(int i=0;i<80000;i++){
            arr1[i]=(int)(Math.random()*8000000);
        }
        selectSort(arr1);
        System.out.println("�����");
        System.out.println(Arrays.toString(arr1));
        Date data2 = new Date();
        String date1Str2 = simpleDateFormat.format(data2);
        System.out.println("������ʱ����="+date1Str2);
    }

    //ѡ�����򷽷�
    public static void selectSort(int [] arr){
        //ʹ�����Ƶ��ķ�ʽ��������ѡ������
        //��1��
        //ԭʼ���ݵ����飺101,34,119,1

        //��һ������ 1,34,119,101
        //�㷨 �ȼ� ������ ���ǿ��԰�һ�����ӵ��㷨 ��ֳɼ򵥵����� �𲽽�� ����ۺ�

        //ѡ������ʱ�临�Ӷ���O(n^2)
        for(int i=0;i<arr.length-1;i++){
          int  minIndex =i;
           int min=arr[i];
            for(int j=i;j<arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];//����min
                    minIndex = j;//����minIndex
                }
            }
            if(minIndex!=i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }//�����Сֵ��ÿ��ѭ��һ��ʼ�ġ���ôû��Ҫ����������
//            System.out.println("��"+(i+1)+"�ֺ���������Ϊ");
//            System.out.println(Arrays.toString(arr));
        }

    }
}
