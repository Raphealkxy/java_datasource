package com.raphael.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by  Raphaelkxy
 * @version: v1.0
 * @description: com.raphael.search
 * @date:2019/8/7
 */
//ע�⣺ʹ�ö��ֲ��ҵ�ǰ���Ǹ������������
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] ={1,8,10,89,1000,1000,1000,1234};
       // int resultIndex = binarySearch(arr,0,arr.length-1,88);
      //  System.out.println("resIndex="+resultIndex);

        List resultIndexList = binarySearch2(arr,0,arr.length-1,1000);
        System.out.println("resIndexList="+resultIndexList);
    }

    //���ֲ����㷨

    /**
     *
     * @param arr
     * @param left �������
     * @param right �ұ�����
     * @param findval Ҫ���ҵ�ֵ
     * @return ���û���ҵ����ͷ���-1
     */
    public static int binarySearch(int []arr,int left,int right,int findval){

        //��left>rigthʱ��˵���ݹ��������飬����û���ҵ�  �ݹ�ջ ��һ��ֱ��
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if(findval>midVal){
            //���ҵݹ�
            return binarySearch(arr,mid+1,right,findval);
        }else if(findval<midVal){
            return  binarySearch(arr,left,mid-1,findval);
        }else {
            return mid;
        }
    }
    //���һ���κ�˼����
    /**
     * �ҵ���������������±�
     * ˼·�����ҵ�midʱ����Ҫ���Ϸ���
     *      ��mid����ֵ�����ɨ�裬������������ҵ�ֵ���±�Ľ��뵽һ��������ArrayList
     *      ��mid����ֵ���ұ�ɨ�� ������������ҵ�ֵ���±궼���뵽������
     */
    public static ArrayList<Integer> binarySearch2(int []arr, int left, int right, int findval){

        //��left>rigthʱ��˵���ݹ��������飬����û���ҵ�  �ݹ�ջ ��һ��ֱ��
        if(left>right){
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if(findval>midVal){
            //���ҵݹ�
            return binarySearch2(arr,mid+1,right,findval);
        }else if(findval<midVal){
            return  binarySearch2(arr,left,mid-1,findval);
        }else {
            ArrayList<Integer>resIndexList=new ArrayList<Integer>();
            int temp =mid-1;
            //��mid���ɨ��
            while (true){
                    if(temp<0||arr[temp]!=findval){
                        break;
                    }
                    //���򣬾ͷ��뵽list������
                    resIndexList.add(temp);
                    temp-=1;
                }
            resIndexList.add(mid);//

            //��mid�ұ�ɨ��
            temp=mid+1;
            while (true){
                if(temp>arr.length-1||arr[temp]!=findval){
                    break;
                }

                resIndexList.add(temp);
                temp+=1;
            }
            return resIndexList;
        }

    }
}
