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
        System.out.println("����ǰ��ʱ����="+date1Str);
//        quickSort(arr1,0,arr.length-1);
        quickSort(arr1,0,arr.length-1);
        Date data2 = new Date();
        String date1Str2 = simpleDateFormat.format(data2);
        System.out.println("������ʱ����="+date1Str2);
        System.out.println(Arrays.toString(arr1));
        System.out.println("arr="+Arrays.toString(arr));
    }


    public static void quickSort(int [] arr,int left,int right){
        int l = left;//���±�
        int r = right;//���±�
        //pivot ����
        int pivot = arr[(left+right)/2];//0 5  ---2
        //whileѭ����Ŀ���Ǳ���pivotֵ����� ��pivot���ֵ�ŵ��ұ�
        //��ʱ����
        int temp =0;
        while(l<r){

            //��pivot���һֱ�� �ҵ����ڵ���pivot�����˳�
            while(arr[l]<pivot){
                l+=1;
            }
            //��pivot�ұ�һֱ�� �ҵ�С�ڵ���pivot��ֵ ���˳�
            while (arr[r]>pivot){
                     r-=1;
            }
            //���l>=r˵��pivot����������ֵ �Ѿ��������ȫ����
            //���ȫ����С�ڵ���pivot��ֵ �ұ�ȫ���Ǵ���pivotֵ
            if(l>=r){
                break;
            }
            //����
             temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //���������󣬷������arr[l]==pivotֵ ���--��ǰ��
            if(arr[l]==pivot){
                r-=1;
            }
            //���������󣬷������arr[r]==pivotֵ ��� l-- ����
            if(arr[r]==pivot){
                l+=1;
            }
        }

        //���l==r ����l++,r--,����Ϊ����ջ���
        if(l==r){
            l+=1;
            r-=1;
        }

        //����ݹ�
        if(left<r){
            quickSort(arr,left,r);
        }
        //���ҵݹ�
        if(right>l){
            quickSort(arr,l,right);
        }
    }
}
