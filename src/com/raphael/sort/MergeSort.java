package com.raphael.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sort
 * @date:2019/8/6
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];//�鲢������Ҫһ������Ŀռ�
        int arr1[]=new int[80000];
        // mergeSort(arr,0,arr.length-1,temp);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = simpleDateFormat.format(date);
        System.out.println(dateString1);
        for(int i=0;i<80000;i++){
            arr1[i]= (int) (Math.random()*8000000);
        }
        mergeSort(arr1,0,arr.length-1,temp);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1  =new SimpleDateFormat("yyyy-MM-d HH:mm:ss");
        String dateString2 = simpleDateFormat.format(date2);
        System.out.println(dateString2);
        System.out.println("�鲢�����="+ Arrays.toString(arr));
    }

    //�ϲ�����


    //��+�ͷ���
    public static void mergeSort(int [] arr,int left,int right,int [] temp){
//        System.out.println("��");
        if(left<right){
            int mid = (left+right)/2;//�м�����
            //����ݹ���зֽ�
            mergeSort(arr,left,mid,temp);
            //���ҵݹ�ֽ�
            mergeSort(arr,mid+1,right,temp);

            //���ϲ�
            merge(arr,left,mid,right,temp);
        }
    }
    /**
     *
     * @param arr �����ԭʼ����
     * @param left ����������еĳ�ʼ����
     * @param mid  �м�����
     * @param right �ұ�����
     * @param temp ����ת������
     */
    public static void merge(int [] arr,int left,int mid,int right,int [] temp){
        System.out.println("��");
        int i =left;//��ʼ��i������������еĳ�ʼ����
        int j = mid+1;//��ʼ��j,�ұ��������еĳ�ʼ����
        int t = 0;//ָ��temp����ĵ�ǰ����

        //(һ��
        //�Ȱ��������ߣ����򣩵����ݰ��չ�����䵽temp����
        //ֱ���������ߵ��������У���һ�ߴ������Ϊֹ
        while(i<=mid&&j<=right){
            //�����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұߵ��������еĵ�ǰԪ��
            //������ߵĵ�ǰԪ�أ�������temp����
            //Ȼ��t++,i++
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t++;
                i++;
            }else {
                temp[t]=arr[j];
                t++;
                j++;
            }
        }

        //(����
        //��ʣ��һ�ߵ�����һ��ȫ����䵽temp
        while(i<=mid){//��ߵ��������л���ʣ���Ԫ�� ��ȫ����䵽temp
            temp[t]=arr[i];
            t++;
            i++;
        }

        while(j<=right){//�ұߵ��������� ����ʣ��Ԫ�� ��ȫ����䵽temp
            temp[t]=arr[j];
            t++;
            j++;
        }
        //(����
        //��temp�����Ԫ�ؿ�����arr
        //ע�⣺������ÿ�ζ�Ҫ�������� �����һ�ε�ʱ�򣬿���2��
        t=0;
        int tempLeft =left;
        while (tempLeft<=right){//��һ�κϲ�ʱtempleft=0,right =1;//���һ�� tempLeft =0 right=7
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }

    }
}
