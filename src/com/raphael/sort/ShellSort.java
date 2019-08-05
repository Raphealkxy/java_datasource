package com.raphael.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sort
 * @date:2019/8/5
 */
public class ShellSort {

    public static void main(String[] args) {
        int arr[]={8,9,1,7,2,3,5,4,6,0};
        //ʹ�����Ƶ��ķ�ʽ����дϣ������
        //shellSort(arr);
       // System.out.println(Arrays.toString(arr));
       // shellSortReal(arr);
        int arr1[]=new int[80000];
        Date date = new Date();
        SimpleDateFormat simpleDateFormat  =new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        String dateString1 = simpleDateFormat.format(date);
        System.out.println(dateString1);
        for(int i=0;i<80000;i++){
            arr1[i]= (int) (Math.random()*8000000);
        }
       // shellSort(arr1);
        shellSort2(arr1);
        System.out.println(Arrays.toString(arr1));
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat1  =new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        String dateString2 = simpleDateFormat.format(date2);
        System.out.println(dateString2);
    }

    //ʹ�����Ƶ��ķ�ʽ����дϣ������ //������
    public static void shellSort(int []arr){
        int temp =0;
        //ϣ������ĵ�1������
        //��Ϊ��1�������ǽ�10�����ݷֲ�5��
        //i��5��ʼ
        for(int i=5;i<arr.length;i++){
            for(int j=i-5;j>=0;j-=5){
                if(arr[j]>arr[j+5]){
                    temp=arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }

        //�ڶ���
        for(int i=2;i<arr.length;i++){
            for(int j=i-2;j>=0;j-=2){
                if(arr[j]>arr[j+2]){
                    temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
            }
        }


        //������
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j-=1){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

    }

    //�����𲽷��� ʹ��ѭ������ ������ �������ֱ������
    public static  void shellSortReal(int [] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            int temp = 0;
            //ϣ������ĵ�1������
            //��Ϊ��1�������ǽ�10�����ݷֲ�5��
            //i��5��ʼ
            //���ַ�ʽ������һ������
            for (int i = gap; i < arr.length; i++) {//����� �м俪ʼ
                for (int j = i - gap; j >= 0; j -= gap) {//ÿ��
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

            System.out.println("ϣ������"+Arrays.toString(arr));
        }
    }


   //ϣ������ �ƶ��� ������в�������
    public static void shellSort2(int [] arr){

        //����gap ������С����
        for(int gap=arr.length/2;gap>0;gap/=2){
            //�ӵ�gap��Ԫ�� ����������ڵ������ֱ�Ӳ�������
           for(int i=gap;i<arr.length;i++){
                int j=i;
                int temp =arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0&&temp<arr[j-gap]){
                        //�ƶ�
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    //���˳�whileѭ���󣬾͸�temp�ҵ������λ��
                    arr[j]=temp;
                }
            }
        }
    }
}
