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
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53,3,542,748,14,214};
        //System.out.println(ar);
        int []arr1 = new int[80000];
        for(int i=0;i<80000;i++){
            arr1[i]=(int)(Math.random()*8000000);
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����="+date1Str);
//        quickSort(arr1,0,arr.length-1);
//        quickSort(arr1,0,arr.length-1);
        radixSort(arr1);

        Date data2 = new Date();
        String date1Str2 = simpleDateFormat.format(data2);
        System.out.println("������ʱ����="+date1Str2);
    }

    //��������ķ���
    public static void radixSort(int []arr) {
        //��һ���������ÿ��Ԫ�صĸ�λ����������

        //1.�õ���������������λ��
        int max = arr[0];//�����һ�������������
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //�õ�������Ǽ�λ��
        int maxLength = (max + "").length();

        //����һ����ά�����ʾ10Ͱ��ÿ��Ͱ����һ��һά����
        //˵��
        //1.��ά�������10��һά����
        //2.Ϊ�˷�ֹ��������ʱ�������������ÿ��һά���飨Ͱ������С��λarr.length
        //3.��������ʹ�ÿռ任ʱ��ľ����㷨
        int[][] bucket = new int[10][arr.length];
        //Ϊ�˼�¼ÿ��Ͱ�У�ʵ�ʴ���˶��ٸ����ݣ���ô������һά��������¼����Ͱÿ�η�������ݸ���
        int[] bucketElementCounts = new int[10];


        //�����������
        //bucketElementCounts[0]����¼����bucket[0]Ͱ�ķ������ݸ���
        int[] bukcetElementCounts = new int[10];

        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            //��һ�֣����ÿ��Ԫ�صĸ�λ���������� ��һ���Ǹ�λ �ڶ�����ʮλ �������ǰ�λ
            for (int j = 0; j < arr.length; j++) {
                //ȡ��ÿ��Ԫ�صĸ�λֵ
                int digitOfElement = arr[j]/n % 10;
                //�����Ӧ��Ͱ��
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;

            }
            //�������Ͱ��˳��һά������±�����ȡ�����ݣ�����ԭ�����飩
            int index = 0;
            //����ÿһͰ������Ͱ�������ݣ����뵽ԭ����
            for (int k = 0; k < bukcetElementCounts.length; k++) {
                //���Ͱ�������ݣ���ô�ŷ���ԭ����
                if (bucketElementCounts[k] != 0) {
                    //ѭ����Ͱ����k��Ͱ(����k��һά���飩������
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //ȡ��Ԫ�ط��뵽arr
                        arr[index] = bucket[k][l];
                        index++;
                    }

                }
                //��1�ִ������Ҫ��ÿ��bukcetElementCounts[k]=0;

                bucketElementCounts[k] = 0;

            }
        //    System.out.println("��1�֣��Ը�λ��������arr=" + Arrays.toString(arr));
        }
    }
}
