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

        //����ð�����������O(n^2) ��80000������ ����
        //����Ҫ��80000�����������
        int []arr1 = new int[80000];
        for(int i=0;i<80000;i++){
            arr1[i]=(int)(Math.random()*8000000);
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����="+date1Str);
        BubbleSort(arr1);
        Date data2 = new Date();
        String date1Str2 = simpleDateFormat.format(data2);
        System.out.println("������ʱ����="+date1Str2);
        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));
        //Ϊ��������⣬���ǰ�ð��������ݱ����
        //��һ�ˣ��������������
        //
    }

    public static void BubbleSort(int arr[]){
        int temp=0;//��������ʱ����
        boolean flag =false;//ʶ����� ��ʾ�Ƿ���й�����
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++) {
                //���ǰ������Ⱥ���������򽻻���������󣬲�����
                if (arr[j] > arr[j + 1]) {
                    flag=true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("��"+(i+1)+"������������Ϊ");
//            System.out.println(Arrays.toString(arr));
            if(!flag){//��һ�������У���һ�ν�����û�з�����
                break;
            }else {
                flag = false;//����flag �����´��ж�
            }

        }
    }
}
