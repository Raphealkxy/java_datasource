package com.raphael.search;

import java.util.Arrays;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.search
 * @date:2019/8/7
 */
public class InsertValue {
    public static void main(String[] args) {
        int [] arr = new int[100];
        for(int i=0;i<100;i++){
            arr[i]=i+1;
        }
       int goalindex = insertValueSearch(arr,0,arr.length-1,99);
        System.out.println("index="+goalindex);
    }

    //��д��ֵ�����㷨
     //˵������ֵ�����㷨��ҲҪ�������������
    /**
     *
     * @param arr ����
     * @param left �������
     * @param rigtht �ұ�����
     * @param findVal ����ֵ
     * @return ����ҵ������ض�Ӧ���±� ���û���ҵ�������-1
     */
    public static int insertValueSearch(int [] arr,int left,int rigtht,int findVal){
        System.out.println("���Ҵ���");
        if(left>rigtht||findVal<arr[0]||findVal>arr[arr.length-1]){
            return -1;
        }
        //���mid ����Ӧ����
        int mid = left+(rigtht-left)*(findVal-arr[left])/(arr[rigtht]-arr[left]);
        int midVal =arr[mid];
        if(midVal>midVal){//˵��Ӧ�����ұߵݹ����
           return insertValueSearch(arr,mid+1,rigtht,findVal);
        }else if(midVal<midVal){
            return insertValueSearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }
    }
}
