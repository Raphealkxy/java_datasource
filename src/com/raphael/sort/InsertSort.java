package com.raphael.sort;

import java.util.Arrays;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.sort
 * @date:2019/8/4
 */
public class InsertSort {

    public static void main(String[] args) {
             int arr[] = {101,34,119,1,-1,89};
             insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //��������
    public static void insertSort(int [] arr){
        //ʹ�����Ƶ��ķ�ʽ
        //��ʼ״̬ 101
        //��һ�� 34 �ڶ��� 119 ������ 1
        //ʹ��forѭ�����ɴ��뻯��
        for(int i=1;i<arr.length;i++){
            //������������
            int insertVal = arr[i];
            int insertIndex = i-1;//��arr[i]ǰ����������±�
            //��insertVa;�ҵ�����λ��
            //˵��
            //1.insertIndex>=0 ��֤�ڸ�insertVal�Ҳ���λ�� ��Խ��
            //2.insertVal<arr[insertIndex]
            while(insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
            // for(int i=1;i<)
            //  int insertVal =arr[1];
            //  int insertindex =1-1;
            System.out.println("��"+i+"�������");
            System.out.println(Arrays.toString(arr));
        }




    }
}
